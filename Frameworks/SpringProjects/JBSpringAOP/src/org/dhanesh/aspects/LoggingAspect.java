package org.dhanesh.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

	@Before("execution( public * org.dhanesh.models.*.get*(*) )")
	public void loggingAdvice(){
		System.out.println("some public get method in models package class called");
	}
	
	@Before("execution( public * org.dhanesh.service.ShapeService.get*() )")
	public void circleAdvice(){
		System.out.println("some public no-arg get method  of Shape Service Called");
	}
	
	@Before("execution( public String org.dhanesh.models.Triangle.getType() )")
	public void triangleAdvice(){
		System.out.println("Triangles getType called");
	}
	
	@Before("allGetters()")
	public void pointCutAdvice(){
		System.out.println("Using PointCut some public/ptotected/private get method  with 0 or more args called");
	}
	
	@Pointcut( "execution( * get*(..) )" )
	public void allGetters(){}
}
