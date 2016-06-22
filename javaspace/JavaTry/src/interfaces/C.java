package interfaces;

public abstract class C extends A implements InterfaceThree{
	
	public void print(){
		//System.out.println(i);		//error
		//System.out.println(i);
	}
	
	public static void main(String[] args){
		System.out.println("I am in abstratct class");
	}
}
