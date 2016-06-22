package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CompletionCall implements Callable<Long>{
		private AtomicInteger count = new AtomicInteger(0);
	  private AtomicLong cnt=new AtomicLong(0);
	  
	  public Long call() throws Exception {
	    long sum = 0;
	    for (long i = 0; i <= 50; i++) {
	      sum += i;
	      if(sum==cnt.get()){
	    	  synchronized(this){
	    	  System.out.println("Stopping thread :: " + Thread.currentThread().getName() + " count :: " + count.incrementAndGet() );
	    	  
	    		 Counter.abc(); 
	    	  }
	    	  Thread.currentThread().stop();
	    	  System.out.println("is curent thread " +Thread.currentThread().getName()+"  alive :: "  + Thread.currentThread().isAlive());
	    	  
	      }
	    }
	    
	  // System.out.println(Thread.currentThread().getName() + " exiting with atomic count :: " + count + " sum :: "+sum);

	    return sum;
	  }
}
