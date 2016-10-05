package org.dhanesh.shapes;

import java.util.Locale;

import org.dhanesh.main.events.DrawEvent;
import org.dhanesh.shapes.basic.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware{

	private Point center;
	private int radius;
	
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public void draw() {
		System.out.println(messageSource.getMessage("greet", null, Locale.FRENCH));
		System.out.println(messageSource.getMessage("circle.point", new Object[]{center.getX(), center.getY()}, null));
		//System.out.println("Center of the circle is :: " + center.getX() + " , " + center.getY());
		System.out.println("And the radius of the circle is :: " + radius);
		
		publisher.publishEvent(new DrawEvent(this));
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Autowired
	@Qualifier("circleCenter")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public Point getCenter() {
		return center;
	}

	

	public int getRadius() {
		return radius;
	}

	@Required
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	

}
