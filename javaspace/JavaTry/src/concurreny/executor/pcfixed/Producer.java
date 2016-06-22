package concurreny.executor.pcfixed;

class Producer implements Runnable{
	Products pr;
	
	public Producer(Products p){
		pr=p;
	}
	
	public void run() {
		synchronized(pr){
		System.out.println(Thread.currentThread().getName() + " putting to :: " + pr.put());
		
			if(pr.getRequired()<pr.value()){
				pr.notifyAll();
			}
		}
		
		
	}
	
	
}
