package strings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import enums.*;
public class StringTry {
	
	static String s1= "papa";
	static String s2 = "papa";
	
	String q1 ="garba";
	String q2 ="garba";
	
	final String a;
	
	{
		a="aam";
	}
	
	StringTry(){

	}
	
	public static void main(String[] args){
		
		
		String a1= "hello";
		String a2= "hello";
		
		a2="world";
		
		StringTry t1 = new StringTry();
		StringTry t2 = new StringTry();
		
		
		if(a1==a2){
			System.out.println("Yes she is right, they are equal");
		}
		else{
			System.out.println("No, these ain't equal " + a2);
		}
		if(s1==s2){
			System.out.println("in static member Yes she is right, they are equal");
		}
		else{
			System.out.println("in static member ,No, these ain't equal");
		}
		if(t1.q1==t1.q2){
			System.out.println("in case of  members of same object : Yes she is right, they are equal");
		}
		else{
			System.out.println("in case of  members of same object : ,No, these ain't equal");
		}
		if(t1.q1==t2.q2){
			System.out.println("in case of  members of different object : Yes she is right, they are equal");
		}
		else{
			System.out.println("in case of  members of different object : ,No, these ain't equal");
		}
		
		System.out.println(Planet.EARTH + " --> " + Planet.EARTH);
		
		for (Planet p : Planet.values()){
			System.out.printf(" %s ---> %f  and %f and %f %n",p, p.mass(), p.radius());
		 }
		
	
	}

}
