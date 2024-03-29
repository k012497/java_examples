package chapter06.circle2;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		String str = String.format("x=%3d, y = %3d", this.x, this.y);
		return str;
	}
	
}
