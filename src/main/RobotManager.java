package main;

/**
 * The class below implements different moves that a robot can make. The robot needs to move within a grid the size of which is provided by the caller
 * In addition it also has a couple of helper methods like getRow, getColumn purely for unit test purposes.
 * Until a valid place is move is made, no instructions will be executed. The code also prevents the Robot from falling off the grid.
 * @author vbalachandran
 *
 */
public class RobotManager implements Robot{
	/**
	 * Was thinking of having a Robot class by itself but given that functionality is not too complex, 
	 * thought i will just have a single class to manage all robot moves
	 */
	private Coordinates coordinates;
	private boolean hasBeenPlaced;
	public RobotManager(Coordinates c) {
		this.coordinates = c;
	}
	
	/**
	 * Place the robot onto the coordinates specified if the input is valid, else do not do anything
	 */
	public void place(int x, int y, String dirInString) {
		if (this.coordinates.set(x, y, dirInString)) {
			this.hasBeenPlaced = true;
		}
	}
	
	/**
	 * Move the robot by 1 unit in the direction it is facing. Prevents Robot from falling off table
	 */
	public void move() {
		if (this.hasBeenPlaced) {
			switch(this.coordinates.getDirection()) {
			case NORTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow()+1, this.coordinates.getDirection());
				break;
			case SOUTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow()-1, this.coordinates.getDirection());
				break;
			case EAST:
				this.coordinates.set(this.coordinates.getColumn()+1, this.coordinates.getRow(), this.coordinates.getDirection());
				break;
			case WEST:
				this.coordinates.set(this.coordinates.getColumn()-1, this.coordinates.getRow(), this.coordinates.getDirection());
				break;
			}
		}
	}
	
	/**
	 * Move the robot to the left
	 */
	public void left() {
		if (this.hasBeenPlaced) {
			switch(this.coordinates.getDirection()) {
			case NORTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.WEST);
				break;
			case SOUTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.EAST);
				break;
			case EAST:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.NORTH);
				break;
			case WEST:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.SOUTH);
				break;
			}	
		}
	}
	
	// Reports the current coordinates of Robot along with the direction it is facing, column being x coordinate and row being y.
	public void report() {
		System.out.println(this.coordinates.getColumn()+", "+this.coordinates.getRow()+", "+this.coordinates.getDirection());
	}
	
	/**
	 * Moves the robot to the right
	 */
	public void right() {
		if (this.hasBeenPlaced) {
			switch(this.coordinates.getDirection()) {
			case NORTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.EAST);
				break;
			case SOUTH:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.WEST);
				break;
			case EAST:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.SOUTH);
				break;
			case WEST:
				this.coordinates.set(this.coordinates.getColumn(), this.coordinates.getRow(), Direction.NORTH);
				break;
			}	
		}		
	}
}
