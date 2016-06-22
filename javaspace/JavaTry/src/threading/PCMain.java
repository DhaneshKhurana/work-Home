package threading;

class PCMain {
	public static void main(String[] args){
		Product p = new Product();
		
		for(int i=0; i<100;i++){
			new Consumer(p).start();
			new Producer(p).start();
		}
	}
}
