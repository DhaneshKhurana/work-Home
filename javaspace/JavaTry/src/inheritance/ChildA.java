package inheritance;

public class ChildA extends ParentA{
	
	public static void main(){
		ChildA obj = new ChildA();
		
		System.out.println(obj.a);
		System.out.println(obj.b);
		System.out.println(obj.d);
		System.out.println(obj.accessC());
		System.out.println();
		
		
	}
}
