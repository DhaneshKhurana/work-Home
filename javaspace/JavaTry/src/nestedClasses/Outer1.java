package nestedClasses;

class Outer1 {
	
	int i=10;
	String cls="outer";
	
	 static class Inner1{
		
		static final int j=20;				//no static variable can be defined in an inner class unless it's final!
		int i=20;
		String cls="inner";
		
		//public static final void var(){}		// no static method can be declared in an inner class be it finlal! 
		
		public void printinner(){
			//System.out.println("inner i :: "+ i + " outer i :: " + Outer1.this.i);
			//System.out.println("inner cls :: "+ cls + " outer cls :: " + Outer1.this.cls);
		}
	}
	
	public void printouter(){
		System.out.println("inner i :: "+ new Inner1().i + " outer i :: " + i);
		System.out.println("outer cls :: "+ cls+ " inner cls :: " + new Inner1().cls + " Inner j :: " + Inner1.j);
	}
	
	public static void main(String[] args){
		Outer1 obj1 = new Outer1();
		//Outer1 obj2 =new Outer1.Inner1();
		
		obj1.printouter();
	}

}
