package threading;

class Consumer implements Runnable{
	Product p;
	
	public Consumer(Product prdct){
		p=prdct;
	}
	
	public void run(){
		p.get();
	}
	
	public void start(){
		new Thread(this).start();
	}
	
	
}
