package test;

import org.junit.Assert;
import org.junit.Test;

import main.Table;
import main.Robot;
import main.RobotManager;

/**
 * Test class to test the RobotManager Implementation. Method name indicates what is being tested.
 * @author vbalachandran
 */
public class RobotManagerTest {

	Robot r;
	Table c = new Table(5, 5);
	@Test
	public void shouldPlaceInCell() {
		r = new RobotManager(c);
		r.place(1, 2, "EAST");
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 1);
	}
	
	@Test
	public void shouldNotPlaceInCell() {
		r = new RobotManager(c);
		r.place(7, 8, "EAST");
		Assert.assertNotEquals(c.getRow(), 7);
		Assert.assertNotEquals(c.getColumn(), 8);
	}

	@Test
	public void shouldMoveRobot() {
		r = new RobotManager(c);
		r.place(1, 2, "EAST");
		r.move();
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 2);
	}
	
	@Test
	public void shouldNotMoveRobot() {
		r = new RobotManager(c);
		r.place(7, 8, "EAST");
		r.move();
		Assert.assertNotEquals(c.getRow(), 7);
		Assert.assertNotEquals(c.getColumn(), 9);
	}
	
	@Test
	public void shouldIgnoreAllMoves() {
		r = new RobotManager(c);
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
	
	@Test
	public void shouldIgnoreInvalidPlace() {
		r = new RobotManager(c);
		r.place(1, 2, "WEST");
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 0);
		r.place(6, 6, "EAST"); // Must Ignore this place command
		r.move();
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 1);
	}
	
	@Test
	public void shouldMakeAllMoves() {
		r = new RobotManager(c);
		r.place(2, 2, "NORTH");
		r.right();
		r.move();
		r.left();
		r.left();
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 3);
	}
	
	@Test
	public void shouldNotFallOffTable() {
		c = new Table(2, 2);
		r = new RobotManager(c);
		r.place(0, 0, "NORTH");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(c.getRow(), 1);
		Assert.assertEquals(c.getColumn(), 0);
	}
	
	@Test
	public void shouldNotMoveOutsideTable() {
		c = new Table(2, 2);
		r = new RobotManager(c);
		r.place(3, 3, "NORTH");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
	
	@Test
	public void shouldIgnoreUntilValidPlaceCommand() {
		r = new RobotManager(c);
		r.place(3, 3, "NORTH");
		r.move();
		r.move();
		r.move();
		r.place(2, 2, "WEST");
		r.move();
		r.left();
		r.right();
		Assert.assertEquals(c.getRow(), 2);
		Assert.assertEquals(c.getColumn(), 1);
	}
	
	@Test
	public void shouldHandleInvalidDirection() {
		r = new RobotManager(c);
		r.place(1, 1, "SOMETHING");
		r.move();
		r.move();
		r.move();
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
}
