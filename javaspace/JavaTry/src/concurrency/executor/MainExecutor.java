package concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MainExecutor {
	private static final int NTHREDS = 10;

	  public static void main(String[] args) {
		  
	    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	    Runnable worker = new MyRunnable(10000000L);
	    for (int i = 0; i < 100; i++) {
	      executor.execute(worker);
	      
	    }
	    executor.shutdown();
	   
	    try {
			executor.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    System.out.println("Finished all threads");
	  }
}
