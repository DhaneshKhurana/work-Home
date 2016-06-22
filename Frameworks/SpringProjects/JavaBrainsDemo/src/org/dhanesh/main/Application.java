package org.dhanesh.main;

import org.dhanesh.shapes.Triangle;
import org.dhanesh.shapes.basic.Point;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Application {
	
	public static void main(String[] args){
		
		
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/resources/SpringOne.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("resources/SpringOne.xml");
		
		
		Triangle tr = (Triangle) factory.getBean("triangle");
		Triangle tr2 = context.getBean(Triangle.class);
		tr.draw();
		tr2.draw();
		
		
		/*Throws exception as there are multiple point beans in springone.xml. so You better getbean by id and cast it.
		Point pt  = context.getBean(Point.class);
		System.out.println("APJ ponit x :: " + pt.getX()  + " y :: " + pt.getY() + " z :: "+ pt.getZ());*/
		
		//let check for singleton objects
		
		tr.setSingletonCounter(1);
		
		System.out.println(tr2.getSingletonCounter());
		
		tr2.setSingletonCounter(2);
		
		Triangle tr3 = context.getBean(Triangle.class);
		
		System.out.println(tr3.getSingletonCounter());
		
		tr3.setSingletonCounter(3);
		
		Triangle tr4 = (Triangle)context.getBean("triangle");
		
		System.out.println(tr4.getSingletonCounter());
		
		ApplicationContext context2 = new ClassPathXmlApplicationContext("resources/SpringOne.xml");
		
		Triangle tr5 = (Triangle)context2.getBean("triangle");
		
		System.out.println(tr5.getSingletonCounter());
		
		Triangle tr6 = (Triangle)context.getBean("triangle");
		
		System.out.println(tr6.getSingletonCounter());
		
		((ConfigurableApplicationContext)context).close();
		((ConfigurableApplicationContext)context2).close();
	}
	
}
