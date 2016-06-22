package threading;

public class Thread2 {
	private static boolean ready=false;
	private static int number;
	
	private static class ReaderThread extends Thread {
		public void run() {
			System.out.println(" before while ");
			while (!ready)
				Thread.yield();
			System.out.println("thread Name :: "+Thread.currentThread().getName()+ " no. ::" + number);
		}
	}
	
	public static void main(String[] args) {
		ReaderThread rd = new ReaderThread();
		for(int i=0;i<10;i++){
			new Thread(rd).start();
		}
		
		new ReaderThread().start();
		try{
			Thread.sleep(10000);
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(" after sleep in main ");
		number = 42;
		ready = true;
	}
}
