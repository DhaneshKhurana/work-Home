package concurrency.executor;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
	  private AtomicInteger value = new AtomicInteger(); 
	 
	  
	  public int getValue(){
	    return value.get();
	  }
	  
	  public int increment(){
	    return value.incrementAndGet();
	  }
	  
	  public static void abc(){
		  System.out.println("Thread name :: " + Thread.currentThread().getName());
	  }
	  
	  
} 