package concurrency.executor;

import java.util.concurrent.atomic.AtomicInteger;

class MyRunnable implements Runnable {
	  private final long countUntil;
	  private AtomicInteger count = new AtomicInteger(0);
	  
	  private volatile int cnt=0;
	  
	  MyRunnable(long count) {
	    this.countUntil = count;
	  }

	  public void run() {		
		long sum = 0;			
		count.incrementAndGet();
		synchronized(this){
	    	sum=++cnt;
	    }
	    for (long i = 1; i < countUntil; i++) {}
	    
	    System.out.println(Thread.currentThread().getName() + " exiting with " +"non-volatile atomic :: " + count + " volatile :: " + cnt + " local :: " +sum);
	  }
} 