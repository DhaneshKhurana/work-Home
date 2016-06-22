public class ChildA2 {
	public static void main(){
		ChildAA obj = new ChildAA();
		
		System.out.println(obj.a);
	//	System.out.println(obj.b);		//not accessible, as b is protected and its a non-subclass, outside the pakcage
	//	System.out.println(obj.d);		//default not accessible outiside package in any case
		System.out.println(obj.accessC());
		
	//	System.out.println(obj.accessD());	//protected memeber can be accessed within any class in same package or in subclass oustide the package, Here though obj is an object of subclass, but being used in non-subclass, where protetced members can't be accessed
		
		
	}
}
