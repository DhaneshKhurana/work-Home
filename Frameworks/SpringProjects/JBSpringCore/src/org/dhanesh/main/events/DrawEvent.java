package org.dhanesh.main.events;

import org.dhanesh.shapes.Shape;
import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Shape source) {
		super(source);
	}
	
	public String toString(){
		return "I am a Draw Event ";
	}

}
