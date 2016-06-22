import inheritance.ParentA;


public class ChildAA extends ParentA{
	
	//protected int accessD(){return super.accessD();}  // as by overridinng the function, u r making it available in non-subclasses as well
	
	 int d;
	
	public static void main(String[] args){
		ChildAA obj = new ChildAA();
		
		System.out.println(obj.a);
		System.out.println(obj.b);
		System.out.println(obj.d);		//can't be accessd, as it's scope is default (i.e. Not avaialable outside the package)
		//System.out.println(obj.accessC());
		//System.out.println(obj.accessD());
		//System.out.println(obj.accessB()); // default method, not accessible even in subclass outside teh package
		
		
		ParentA obj2 = new ChildAA();
		
		System.out.println(obj2.a);
		
	}

}
