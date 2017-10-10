package main;

public interface Robot {
	public void place(int x, int y, String dirInString);
	public void move();
	public void left();
	public void right();
	public void report();
}
