package main;

public enum Direction {
	NORTH,
	SOUTH,
	EAST,
	WEST;
	
	/**
	 * Helper method to return direction from an input string, will return null if string is not valid
	 * @param sampleDirection
	 * @return Direction enum
	 */
	public static Direction getDirection(String sampleDirection) {
		for (Direction d: Direction.values()) {
			if (sampleDirection.equalsIgnoreCase(d.name())) {
				return d;
			}
		}
		return null;
	}
}

