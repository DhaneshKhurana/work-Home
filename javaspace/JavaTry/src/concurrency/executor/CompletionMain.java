package concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionMain {

	private static final int NTHREDS = 10;

		  public static void main(String[] args) throws InterruptedException, ExecutionException {

		    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
		    CompletionService<Long> cps = new ExecutorCompletionService<Long>(executor);
			
		    Callable<Long> c = new CompletionCall();
		    for (int i = 0; i < 50; i++) {
		      cps.submit(c);
		     // System.out.println("tasksubmitted :: " + i);
		    }
		    
		    long sum = 0;

		    for (int i=0; i<50; i++) {
		      try {
		    	  long result=0;
		    	  Future<Long> ft = cps.take();
		    	  if(ft==null){
		    		  
		    		  System.out.println("future is cancelled");
		    	  }else{
		    		 // result =(long)ft.get();
		    	  }
		    	  
		    	  System.out.println("individual sum returned :: " +result);  
		        sum += result;
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }
		    }
		    System.out.println("total sum :: " +sum);
		    executor.shutdown();
		    System.out.println("shut down");
		  }
	
}
