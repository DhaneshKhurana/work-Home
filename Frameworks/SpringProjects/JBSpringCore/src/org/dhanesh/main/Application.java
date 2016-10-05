package org.dhanesh.main;

import org.dhanesh.shapes.Shape;
import org.dhanesh.shapes.Triangle;
import org.dhanesh.shapes.basic.Point;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class Application {
	
	public static void main(String[] args){
		
		//Better never use BeanFacotry, Always use ApplicationConext
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/resources/SpringOne.xml"));
		//ApplicationContext context = new ClassPathXmlApplicationContext("resources/SpringOne.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("resources/SpringOne.xml");
		context.registerShutdownHook();
		
		Triangle tr = (Triangle) context.getBean("triangle");
		//throws error as there are two triangle bean, so it doesn;t know which bean you are asking for
		//Triangle tr2 = context.getBean(Triangle.class);
		Triangle tr2 = (Triangle)context.getBean("triangle2");
		
		tr.draw();
		tr2.draw();
		
		//let check for singleton objects
		tr.setSingletonCounter(1);
		System.out.println(tr2.getSingletonCounter());
		tr2.setSingletonCounter(2);
		Triangle tr3 = (Triangle) context.getBean("triangle");
		System.out.println(tr3.getSingletonCounter());
		tr3.setSingletonCounter(3);
		Triangle tr4 = (Triangle)context.getBean("triangle");
		System.out.println(tr4.getSingletonCounter());
		
		//Let us draw a circle shape by implementing coding to interfaces
		Shape shape = (Shape)context.getBean("circle");
		shape.draw();
		
		//creating another BeanFactory of SpringContainer
		/*ApplicationContext context2 = new ClassPathXmlApplicationContext("resources/SpringOne.xml");
		Triangle tr5 = (Triangle)context2.getBean("triangle");
		System.out.println(tr5.getSingletonCounter());
		Triangle tr6 = (Triangle)context.getBean("triangle");
		System.out.println(tr6.getSingletonCounter());*/
		
		
		System.out.println("\n~~~Printing the greeting messgae~~~~\n");
		System.out.println(context.getMessage("greet", null,null ));
		System.out.println(context.getMessage("circle.point", new Object[]{10, 20},null));
		
		
	
	}
	
}
