package exercises;

import java.util.Scanner;

public class SmallProgs {
	
	int i=10;
	
	
//	public void abc(){static int y=9;}		// you can-not have static varaiables inside a method!
	
	// iterative factorial method
	public static int fact(int num)
	{
		int var=1;
		while(num>0)
		{
			var = var*num;
			num--;
		}
		return var;
	}
	
	//recursive factorial
	public static int recFact(int num)
	{
		if(num==1 || num==0)
			return 1;
		else
			return num*recFact(num-1);
	}
	
	//iterative fibonicci
	public static void fib(int num)
	{
		System.out.println("printing fibonicii using iterative algo");
		System.out.print("1"+"\t");
		int old= 0;
		int curr= 1;
		int newVar;
		while(num>1)
		{
			newVar = old + curr;
			System.out.print(newVar+"\t");
			old = curr;
			curr = newVar;
			num--;
		}
		System.out.println();
	}
	

	//recursive fibonicci
	public static void recFib2(int num, int o, int c)
	{
		int curr = c;
		int old = o;
		int next = curr + old;
		
		if(num>1)
			{
				num-=1;
				System.out.print(next+"\t");
				recFib2(num, curr, next);
			}
		System.out.println();
		return;
	}

	//sum of fours
	public static void fours(int[] arr)
	{
	
	 for(int i=0; i<arr.length-1;i++){
			int sum=arr[i];
			if(sum==4){
				System.out.print("("+i+")\t");
				continue;
			}
			else if(sum>4)
				continue;
			else{
				for(int j=i+1;j<arr.length-1;j++){
					sum=arr[i]+arr[j];
					if(sum==4){
						System.out.print("("+i+", "+j+")\t");
						continue;
					}
					else if(sum>4){
						continue;
					}
					else{
						for(int k=j+1;k<arr.length-1;k++){
							sum=arr[i]+arr[j]+arr[k];
							if(sum==4){
								System.out.print("("+i+", "+j+", "+k+")\t");
								continue;
							}
							else if(sum>4){
								continue;
							}
							else{
								for(int l=k+1;l<arr.length-1;l++){
									sum=arr[i]+arr[j]+arr[k]+arr[l];
									if(sum==4){
										System.out.print("("+i+", "+j+", "+k+", "+l+")\t");
										continue;
									}
									else if(sum>4){
										continue;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void main (String[] args)
	{
		
		/*System.out.println("Enter a number for factorial and fibonacci");
		Scanner inpt = new Scanner(System.in);
		int num = inpt.nextInt();
		int fact2 = fact(num);
		System.out.println("factorial using interative is --> " + fact2);
		int fact1 = recFact(num);
		System.out.println("factorial using recursion --> " + fact1);
		fib(num);
		System.out.println("-- fibanocci using recursion2 -- ");
		System.out.print("1\t");
		recFib2(num,0,1);
		inpt.close();
		System.out.println();
		int[] arr={1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4};
		fours(arr);*/
		
		SmallProgs imp = new SmallProgs();
		final SmallProgs imp2 = new SmallProgs();
		imp2.i=20;
		System.out.println(imp2.i);
		
		//imp2=imp;
		
		//imp2= new SmallProgs();
		
	}
}

