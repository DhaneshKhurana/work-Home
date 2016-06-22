package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

class MyCallable implements Callable<Long> {
	
	 private AtomicInteger count = new AtomicInteger(0);
	  
	  private volatile int cnt=0;
	  
	  public Long call() throws Exception {
	    long sum = 0;
	    for (long i = 0; i <= 50; i++) {
	      sum += i;
	    }
	    count.incrementAndGet();
	   System.out.println(Thread.currentThread().getName() + " exiting with atomic count :: " + count + " sum :: "+sum);

	    return sum;
	  }

	}
