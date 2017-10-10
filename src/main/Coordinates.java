package main;

public class Coordinates {
	private int MAXROWSIZE;
	private int MAXCOLUMNSIZE;
	private int currentRow;
	private int currentColumn;
	private Direction orientation;
	
	public Coordinates(int rowSize, int columnSize) {
			this.MAXROWSIZE = rowSize;
			this.MAXCOLUMNSIZE = columnSize;
			this.currentRow = -1;
			this.currentColumn = -1;
	}
	
	public boolean set(int column, int row, String direction) {
		Direction d = Direction.getDirection(direction);
		if (d != null && determineIfSafe(row, column)) {
			this.currentColumn = column;
			this.currentRow = row;
			this.orientation=d;
			return true;
		}
		return false;
	}
	
	public void set(int column, int row, Direction direction) {
		if (determineIfSafe(row, column)) {
			this.currentRow = row;
			this.currentColumn = column;
			this.orientation = direction;
		}
	}
	
	public int getRow() {
		return this.currentRow;
	}
	
	public int getColumn() {
		return this.currentColumn;
	}
	
	public Direction getDirection() {
		return this.orientation;
	}
	
	/**
	 * Helper method that just returns if coordinates fall within grid
	 * @param row
	 * @param column
	 * @return boolean
	 */
	private boolean determineIfSafe(int row, int column) {
		return row >= 0 && row < this.MAXROWSIZE && column >= 0 && column < this.MAXCOLUMNSIZE;
	}
}
