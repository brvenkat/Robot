package main;

public class RobotManager implements Robot{
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
	}
	
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
	
	// Adding just for purpose of unit test
	public int getRow() {
		return this.currentRow;
	}
	
	public int getColumn() {
		return this.currentColumn;
	}
	public void report() {
		System.out.println("x coordinate "+this.currentColumn+" y coordinate "+this.currentRow+" direction "+this.orientation);
	}
	
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
	
	private boolean isSafeMove() {
		if (!this.hasBeenPlaced) {
			return false;
		}
		return this.currentRow >= 0 && this.currentRow < this.rowSize && this.currentColumn >= 0 && this.currentColumn < this.columnSize;
	}
	
	private boolean isSafeMove(int row, int column) {
		return row >=0 && row < this.rowSize && column >=0 && column < this.columnSize;
	}
	
	private Direction getDirection(String sampleDirection) {
		for (Direction d: Direction.values()) {
			if (sampleDirection.equalsIgnoreCase(d.name())) {
				return d;
			}
		}
		return null;
	}
}
