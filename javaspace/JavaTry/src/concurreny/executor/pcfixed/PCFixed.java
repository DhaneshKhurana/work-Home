package concurreny.executor.pcfixed;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PCFixed {
	
	public static void main(String[] args){
		Products p = new Products();
		ExecutorService producer = Executors.newFixedThreadPool(20);
		ExecutorService consumer = Executors.newFixedThreadPool(20);
		//Runnable pr = new Producer(p);
		//Runnable cn = new Consumer(p);
		for(int i=0; i<100; i++){
			consumer.execute(new Consumer(p));
			producer.execute(new Producer(p));
			
		}
		
		producer.shutdown();
		consumer.shutdown();
		
		try {
			producer.awaitTermination(5000, TimeUnit.MILLISECONDS);
			consumer.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("finally sab khapi");
		
	}
}
