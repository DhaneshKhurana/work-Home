package interfaces;

public class A extends B implements InterfaceOne, InterfaceTwo{
	//static int i;
	
	//void add(){System.out.println("I am add method of class A");}  // generates error as you can not reduce the visibility of inherited method!
	
	public void print(){
		//System.out.println(i);		//error
		System.out.println(super.i);
	}
	
	public static void main(String[] args){
		
		A a = new A();
		
		System.out.println(InterfaceOne.i);
		System.out.println(InterfaceTwo.i);
		
		System.out.println(InterfaceThree.i);
		
		//System.out.println(i);		//error
		a.print();
		
		a.add();		//declared in interfaceone, defined in parent class B, that's why no error
	}
}
