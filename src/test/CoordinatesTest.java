package test;

import org.junit.Assert;
import org.junit.Test;

import main.Coordinates;
import main.Direction;

public class CoordinatesTest {

	Coordinates c = new Coordinates(5, 5);
	@Test
	public void shouldNotPlaceRobot() {
		c.set(6, 6, "WEST");
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
	@Test
	public void shouldPlaceRobot() {
		c.set(2, 3, "WEST");
		Assert.assertEquals(c.getRow(), 3);
		Assert.assertEquals(c.getColumn(), 2);
		Assert.assertEquals(c.getDirection(), Direction.WEST);
	}
	@Test
	public void shouldNotPlaceInInvalidDirection() {
		c.set(4, 3, "SOME");
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
	@Test
	public void shouldNotPlaceInNegativeXCoordinate() {
		c.set(-3, 0, "WEST");
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
	@Test
	public void shouldNotPlaceInNegativeYCoordinate() {
		c.set(2, -1, "WEST");
		Assert.assertEquals(c.getRow(), -1);
		Assert.assertEquals(c.getColumn(), -1);
	}
}
