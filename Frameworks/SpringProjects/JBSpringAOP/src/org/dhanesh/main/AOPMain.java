package org.dhanesh.main;

import org.dhanesh.service.ShapeService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPMain {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		ShapeService ss = ctx.getBean("shapeService", ShapeService.class);
		System.out.println(ss.getCircle().getType());
		System.out.println(ss.getTriangle().getType());
		ctx.close();
	}
}
