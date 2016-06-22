package concurrency.executor;

import java.util.ArrayList;
import java.util.List;

class MainRunnable {

	  public static void main(String[] args) {
	    
	    List<Thread> threads = new ArrayList<Thread>();
	    MyRunnable a = new MyRunnable(10000000L);
	    for (int i = 0; i <= 100; i++) {
	      Thread worker = new Thread(a);
	      
	      worker.setName(String.valueOf(i));
	      worker.start();
	      threads.add(worker);
	    }
	    int running = 0;
	    do {
	      running = 0;
	      for (Thread thread : threads) {
	        if (thread.isAlive()) {
	          running++;
	        }
	      }
	      //System.out.println("We have " + running + " running threads. ");
	    } while (running > 0);

	  }
}