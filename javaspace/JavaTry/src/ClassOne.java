
public class ClassOne {

	int i=10;
	
	public static void main(String[] args){
		
		ClassOne obj1 = (ClassOne)new Object();
		System.out.println(obj1.hashCode());
	}
}
