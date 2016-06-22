package simpleOperations;

import regularExpressions.RegexTestHarness;

final class Swap {
	
	private int a=10;
	private int b=20;
	
	protected void finalize() throws Throwable {
		
		System.out.println("omg");
		System.gc();
	};
	
	public void funone(Object ob){
		System.out.println(ob + " in object");
	}
	
	public void funone(Swap ob){
		System.out.println(ob + " in swap");
	}
	
	public void funone(RegexTestHarness sw){
		System.out.println(sw + " in regex");
	}
	
	public static void main(String[] args){
		int a=10;
		int b=51;
		
		Swap sw1 = new Swap();
		try {
			sw1.finalize();
			
		//	sw1.funone(null);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		a=a^b;
		b=a^b;
		a=a^b;
		
		int d = 8/3;
		
		System.out.println("a :: "  + a + " b :: " + b + " d:: "+  d +":: " +  8/3);
	}
}
