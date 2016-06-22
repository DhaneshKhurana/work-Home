package concurreny.executor.pcfixed;

class Consumer implements Runnable{
	Products pr;
	
	public Consumer(Products p){
		pr=p;
	}
	
	public void run(){
		synchronized(pr){
		while(pr.getRequired()>=pr.value()){
			
				try {
					System.out.println("Required :: " + pr.required.incrementAndGet() + " Available :: " + pr.value());
					pr.wait();
				} catch (Exception e) {
					System.out.println(" problem in consumer :: " + e);
				}finally{
					pr.required.decrementAndGet();
				}
			}
			
		
		System.out.println(Thread.currentThread().getName() + " leaving to :: " + pr.get()+ " and count :: " + pr.count++);
		}
	}
}
