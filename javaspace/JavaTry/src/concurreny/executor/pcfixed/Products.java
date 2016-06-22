package concurreny.executor.pcfixed;

import java.util.concurrent.atomic.AtomicInteger;

class Products {
	private final AtomicInteger num = new AtomicInteger();
	AtomicInteger required = new AtomicInteger();
	
	 int count=1;
	
	int getRequired(){
		return required.get();
	}
	
	int value(){
		return num.get();
	}
	
	int get(){
		return num.decrementAndGet();
	}
	
	int put(){
		return num.incrementAndGet();
	}
	
}
