package threading;

import java.util.ArrayList;
import java.util.List;

public class Thread1Main {
	
	
	
	
	public static void main(String[] args){

		
		Thread1 obj = new Thread1();
		Thread1 obj2 = new Thread1();
		
		Thread t1 = new Thread(obj, "t1");
		Thread t2 = new Thread(obj, "t2");
		Thread t3 = new Thread(obj, "t3");
		Thread t4 = new Thread(obj, "t4");
		
		Thread t11 = new Thread(obj2, "t11");
		Thread t12 = new Thread(obj2, "t12");
		Thread t13 = new Thread(obj2, "t13");
		Thread t14 = new Thread(obj2, "t14");
		Thread t15 = new Thread(obj2, "t15");
		Thread t16 = new Thread(obj2, "t16");
		Thread t17 = new Thread(obj2, "t17");
		Thread t18 = new Thread(obj2, "t18");
		
		Thread t5 = new Thread(obj, "t5");
		Thread t6 = new Thread(obj, "t6");
		Thread t7 = new Thread(obj, "t7");
		Thread t8 = new Thread(obj, "t8");
		Thread t9 = new Thread(obj, "t9");
		Thread t10 = new Thread(obj, "t10");
		
		
		Thread t19 = new Thread(obj2, "t19");
		Thread t20 = new Thread(obj2, "t20");
		
		t1.start();
		t11.start();
		t12.start();
		t13.start();
		t14.start();
		t15.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		
		
		t16.start();
		t17.start();
		t18.start();
		t19.start();
		t20.start();


	}
}
