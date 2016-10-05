package org.dhanesh.service;

import org.dhanesh.models.Circle;
import org.dhanesh.models.Triangle;

public class ShapeService {
	
	private Triangle triangle;
	private Circle circle;
	

	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
	
}
