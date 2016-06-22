import java.util.Scanner;

class TestClass {
    public static void main(String args[] ) throws Exception {
    	System.out.println("");
    	Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        for(int i=0;i<num;i++){
        	int n = sc.nextInt();
        	if(n%2==0){
            	System.out.println("Even");
            }else{
            	System.out.println("Odd");
            }
        }
        sc.close();
    }
}
