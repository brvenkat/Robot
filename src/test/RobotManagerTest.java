package test;

import org.junit.Assert;
import org.junit.Test;
import main.Robot;
import main.RobotManager;

/**
 * Test class to test the RobotManager Implementation. Method name indicates what is being tested.
 * @author vbalachandran
 */
public class RobotManagerTest {

	Robot r;
	@Test
	public void shouldPlaceInCell() {
		r = new RobotManager(5, 5);
		r.place(1, 2, "EAST");
		Assert.assertEquals(r.getRow(), 1);
		Assert.assertEquals(r.getColumn(), 2);
	}
	
	@Test
	public void shouldNotPlaceInCell() {
		r = new RobotManager(5, 5);
		r.place(7, 8, "EAST");
		Assert.assertNotEquals(r.getRow(), 7);
		Assert.assertNotEquals(r.getColumn(), 8);
	}

	@Test
	public void shouldMoveRobot() {
		r = new RobotManager(5, 5);
		r.place(1, 2, "EAST");
		r.move();
		Assert.assertEquals(r.getRow(), 1);
		Assert.assertEquals(r.getColumn(), 3);
	}
	
	@Test
	public void shouldNotMoveRobot() {
		r = new RobotManager(5, 5);
		r.place(7, 8, "EAST");
		r.move();
		Assert.assertNotEquals(r.getRow(), 7);
		Assert.assertNotEquals(r.getColumn(), 9);
	}
	
	@Test
	public void shouldIgnoreAllMoves() {
		r = new RobotManager(5, 5);
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(r.getRow(), -1);
		Assert.assertEquals(r.getColumn(), -1);
	}
	
	@Test
	public void shouldIgnoreInvalidPlace() {
		r = new RobotManager(5, 5);
		r.place(1, 2, "WEST");
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(r.getRow(), 1);
		Assert.assertEquals(r.getColumn(), 1);
		r.place(6, 6, "EAST"); // Must Ignore this place command
		r.move();
		Assert.assertEquals(r.getRow(), 1);
		Assert.assertEquals(r.getColumn(), 2);
	}
	
	@Test
	public void shouldMakeAllMoves() {
		r = new RobotManager(5, 5);
		r.place(2, 2, "NORTH");
		r.right();
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(r.getRow(), 2);
		Assert.assertEquals(r.getColumn(), 3);
	}
	
	@Test
	public void shouldNotFallOffTable() {
		r = new RobotManager(2, 2);
		r.place(0, 0, "NORTH");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(r.getRow(), 1);
		Assert.assertEquals(r.getColumn(), 0);
	}
	
	@Test
	public void shouldNotMoveOutsideTable() {
		r = new RobotManager(2, 2);
		r.place(3, 3, "NORTH");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(r.getRow(), -1);
		Assert.assertEquals(r.getColumn(), -1);
	}
	
	@Test
	public void shouldIgnoreUntilValidPlaceCommand() {
		r = new RobotManager(3, 3);
		r.place(3, 3, "NORTH");
		r.move();
		r.move();
		r.move();
		r.place(2, 2, "WEST");
		r.move();
		r.left();
		r.right();
		Assert.assertEquals(r.getRow(), 2);
		Assert.assertEquals(r.getColumn(), 1);
	}
	
	@Test
	public void shouldHandleInvalidDirection() {
		r = new RobotManager(2, 2);
		r.place(1, 1, "SOMETHING");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(r.getRow(), -1);
		Assert.assertEquals(r.getColumn(), -1);
	}
}
