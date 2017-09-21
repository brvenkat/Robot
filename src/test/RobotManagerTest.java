package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import main.Robot;
import main.RobotManager;

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
}
