package exceptions;

public class InnerFinally {

	
	public static void main(String[] args){
		try{
			try{
				int a=0, b=10;
				int c=b/a;
				System.out.println(c);
			}catch(NullPointerException ne){
				System.out.println("inside innner null pointer catch");
			}finally{
				System.out.println("Inside inner finally");
			}
		}catch(ArithmeticException ae){
			System.out.println("inside outer catch :: " + ae);
			
		}finally{
			System.out.println("inside outer finally");
		}
	}
}
