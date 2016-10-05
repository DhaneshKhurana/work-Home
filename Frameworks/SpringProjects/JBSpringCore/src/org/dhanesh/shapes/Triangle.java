package org.dhanesh.shapes;

import java.util.List;

import javax.annotation.Resource;

import org.dhanesh.shapes.basic.Point;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ResourceBundleMessageSource;

public class Triangle implements Shape, ApplicationContextAware , InitializingBean, DisposableBean{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	private Point pointX;
	private Point pointY;
	
	private int height;
	private int base;
	private int hypotenus;
	
	private int sideOne;
	private int sideTwo;
	private int sideThree;
	
	
	private String type;
	
	private int singletonCounter=0;
	
	private List<Point> points;
	
	private ApplicationContext context;
	
	
	public int getSingletonCounter() {
		return singletonCounter;
	}

	public void setSingletonCounter(int singletonCounter) {
		this.singletonCounter = singletonCounter;
	}

	
	public Point getPointX() {
		return pointX;
	}

	public void setPointX(Point pointX) {
		this.pointX = pointX;
	}

	public Point getPointY() {
		return pointY;
	}

	public void setPointY(Point pointY) {
		this.pointY = pointY;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public Triangle(){
		
	}
	
	public Triangle(int sideThree){
		this.sideThree = sideThree;
	}
	
	public Triangle(String type, int sideOne){
		this.type = type;
		this.sideOne = sideOne;
	}
	
	public Triangle(int sideTwo, int sideOne, String type){
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.type = type;
	}
	
	public Triangle(int sideThree, int sideTwo, int sideOne, String type){
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
		this.type = type;
		
	}
	
	
	public void draw(){
		System.out.println(" Trinagle drawn with type :: " + type + " height :: " + height + " base ::" + base + " hypoten :: "
						+ hypotenus + " sideOne :: " + sideOne + " sideTwo :: " + sideTwo + " sideThree :: " + sideThree);
		
		System.out.println("printing points");
		
		System.out.println("point A :: " + pointA.getX() + "," + pointA.getY() + "," + pointA.getZ());
		System.out.println("point B :: " + pointB.getX() + "," + pointB.getY() + "," + pointB.getZ());
		System.out.println("point C :: " + pointC.getX() + "," + pointC.getY() + "," + pointC.getZ());
		
		System.out.println("point X :: " + pointX.getX() + "," + pointX.getY() + "," + pointX.getZ());
		System.out.println("point Y :: " + pointY.getX() + "," + pointY.getY() + "," + pointY.getZ());
		
		
		for(Point point : points){
			System.out.println("point :: " + point.getX() + "," + point.getY() + "," + point.getZ());
		}
	}
	
	
	
	
	
	
	
	//========Getters and setters ======================//

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	/*public int getHypotenus() {
		return hypotenus;
	}*/

	public void setHypotenus(int hypotenus) {
		this.hypotenus = hypotenus;
	}

	public String getType() {
		return type;
	}


	public int getSideOne() {
		return sideOne;
	}


	public int getSideTwo() {
		return sideTwo;
	}


	public int getSideThree() {
		return sideThree;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("hi I am InitializingBean overriddent method");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("I am DisposableBean overridden method and about to be destroyed");
		
	}
	
	public void myInit(){
		System.out.println("I am configures as initalizing method in XML");
	}
	
	public void myDestroy(){
		System.out.println("I am configures as destroy method in XML");
	}
	
	
	
}
