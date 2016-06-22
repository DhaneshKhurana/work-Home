package threading;

import java.util.Random;

public class Thread1 implements Runnable{

	private int lastNumber;
	private int[] lastFactors;
	private long hits;
	private long cacheHits;
	
	public synchronized long getHits() {
		return hits; 
	}
	
	public synchronized double getCacheHitRatio() {
		return (double) cacheHits / (double) hits;
	}
	
	public synchronized int getlastNumber() {
		return lastNumber; 
	}
	
	public synchronized int[] factor(int num){
		int ret[]=new int[10];
		for(int i=1, j=0; i<=num && num>0 ;i++ ){
			if(num%i==0){
				ret[j++]=i;
				num/=i;
			}
		}
		return ret;
	}
	
	public String toString(){
		return ("hits :: " + hits + " cache hits :: " + cacheHits);
	}
	
	public void run(){
		int i = 10;
		int[] factors = null;
		
		
		//System.out.println("do i have an object :: " + this);
		
		synchronized (this) {
			System.out.print("\n" + Thread.currentThread().getName() +" Gonna incremented hits " );
			++hits;
			System.out.println(Thread.currentThread().getName() + " just incremented hits to " + getHits());
			try{
				Thread.sleep(2000);
			}catch(Exception e){
				System.out.println(e);
			}
			
			if (i==lastNumber) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if (factors == null) {
			factors = factor(i);
			synchronized (this) {
				//System.out.println("Gonna Update lastnumber " + this.getlastNumber());
				lastNumber++;
				lastFactors = factors.clone();
				//System.out.println("just updated lastNumber " + this.getlastNumber());
			}
		}
	}

}
