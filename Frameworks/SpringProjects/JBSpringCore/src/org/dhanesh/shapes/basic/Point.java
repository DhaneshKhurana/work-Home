package org.dhanesh.shapes.basic;

public class Point {
	
	private int x=0;
	private int y=0;
	private int z=0;
	
	public Point() {
		
	}
	
	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/**
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	
	
	

}
