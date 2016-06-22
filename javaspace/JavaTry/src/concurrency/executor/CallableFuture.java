package concurrency.executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallableFuture {
	private static final int NTHREDS = 10;

	  public static void main(String[] args) {

	    ExecutorService executor = Executors.newFixedThreadPool(NTHREDS);
	    List<Future<Long>> list = new ArrayList<Future<Long>>();
	    
	    MyCallable c = new MyCallable();
	    
	    for (int i = 0; i < 200; i++) {
	      Future<Long> sumresult = executor.submit(c);
	      list.add(sumresult);
	    }
	    long sum = 0;
	    System.out.println(list.size());

	    for (Future<Long> future : list) {
	      try {
	    	  long result = future.get();
	    	  System.out.println("individual sum returned :: " + result);  
	        sum += result;
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      } catch (ExecutionException e) {
	        e.printStackTrace();
	      }
	    }
	    System.out.println("total sum :: " +sum);
	    executor.shutdown();
	    System.out.println("shut down");
	  }
}
