package threading;

class Producer implements Runnable{
	Product p;
	
	public Producer(Product prd){
		p =prd;
	}
	
	public void run(){
		p.put();
	}
	
	public void start(){
		new Thread(this).start();;
	}
	
}
