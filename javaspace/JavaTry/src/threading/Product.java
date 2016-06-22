package threading;

class Product {
	private int num;
	private int required;
	
	public Product(){
		num=0;
		required=0;
	}
	
	synchronized void get(){
		//System.out.println("Value of num in get :: " + num);
		if(num==0 || required>=num){
			try{
				System.out.println("required :: " + ++required + " Available :: " + num);
				wait();
			}catch(InterruptedException ie){
				System.out.println(ie);
			}finally{
				--required;
				//System.out.println("in finally with required :: " + --required);
			}
			
		}
		
		System.out.println("rest :: " + --num);
	}
	
	synchronized void put(){
		//System.out.println("value of num in put :: " + num);
		if(num>=required){
			notifyAll();
		}
		System.out.println("capacity :: "  + ++num);
	}
}
