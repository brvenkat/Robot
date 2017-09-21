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
	private int rowSize;
	private int columnSize;
	private Direction orientation;
	private int currentRow;
	private int currentColumn;
	private boolean hasBeenPlaced;
	public RobotManager(int rowSize, int columnSize) {
		this.rowSize = rowSize;
		this.columnSize = columnSize;
		this.hasBeenPlaced = false;
		this.currentRow = -1;
		this.currentColumn = -1;
	}
	
	/**
	 * Place the robot onto the coordinates specified if the input is valid, else do not do anything
	 */
	public void place(int x, int y, String dirInString) {
		Direction d = getDirection(dirInString);
		boolean isValidCoordinate  = x >=0 && x < this.rowSize && y >= 0 && y < this.columnSize;
		if (isValidCoordinate && d != null) {
			this.currentRow = x;
			this.currentColumn = y;
			this.orientation = d;
			this.hasBeenPlaced = true;
		}
	}
	
	/**
	 * Move the robot by 1 unit in the direction it is facing. Prevents Robot from falling off table
	 */
	public void move() {
		if (isSafeMove()) {
			switch(this.orientation) {
			case NORTH:
				if (isSafeMove(this.currentRow+1, this.currentColumn))
					this.currentRow += 1;
				break;
			case SOUTH:
				if (isSafeMove(this.currentRow-1, this.currentColumn))
					this.currentRow -= 1;
				break;
			case EAST:
				if (isSafeMove(this.currentRow, this.currentColumn+1))
					this.currentColumn += 1;
				break;
			case WEST:
				if (isSafeMove(this.currentRow, this.currentColumn-1))
					this.currentColumn -= 1;
				break;
			}
		}
	}
	
	/**
	 * Move the robot to the left
	 */
	public void left() {
		if (isSafeMove()) {
			switch(this.orientation) {
			case NORTH:
				this.orientation = Direction.WEST;
				break;
			case SOUTH:
				this.orientation = Direction.EAST;
				break;
			case EAST:
				this.orientation = Direction.NORTH;
				break;
			case WEST:
				this.orientation = Direction.SOUTH;
				break;
			}	
		}
	}
	
	// Adding just for purpose of unit test, returns current row where Robot is located
	public int getRow() {
		return this.currentRow;
	}
	
	// Adding just for purpose of unit test, returns current column where Robot is located
	public int getColumn() {
		return this.currentColumn;
	}
	
	// Reports the current coordinates of Robot along with the direction it is facing, column being x coordinate and row being y.
	public void report() {
		System.out.println("x coordinate "+this.currentColumn+" y coordinate "+this.currentRow+" direction "+this.orientation);
	}
	
	/**
	 * Moves the robot to the right
	 */
	public void right() {
		if (isSafeMove()) {
			switch(this.orientation) {
			case NORTH:
				this.orientation = Direction.EAST;
				break;
			case SOUTH:
				this.orientation = Direction.WEST;
				break;
			case EAST:
				this.orientation = Direction.SOUTH;
				break;
			case WEST:
				this.orientation = Direction.NORTH;
				break;
			}	
		}		
	}
	
	/**
	 * Helper method that checks if a move can be made. 
	 * Move CANNOT be made if no valid place move has been issued prior to this or if coordinates are not within grid
	 * @return boolean
	 */
	private boolean isSafeMove() {
		if (!this.hasBeenPlaced) {
			return false;
		}
		return this.currentRow >= 0 && this.currentRow < this.rowSize && this.currentColumn >= 0 && this.currentColumn < this.columnSize;
	}
	
	/**
	 * Helper method that just returns if coordinates fall within grid
	 * @param row
	 * @param column
	 * @return boolean
	 */
	private boolean isSafeMove(int row, int column) {
		return row >=0 && row < this.rowSize && column >=0 && column < this.columnSize;
	}
	
	/**
	 * Helper method to return direction from an input string, will return null if string is not valid
	 * @param sampleDirection
	 * @return Direction enum
	 */
	private Direction getDirection(String sampleDirection) {
		for (Direction d: Direction.values()) {
			if (sampleDirection.equalsIgnoreCase(d.name())) {
				return d;
			}
		}
		return null;
	}
}
