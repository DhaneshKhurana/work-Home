
public class Problem2 {

	public static void main(String[] args){
		long sum=2L;
		long next=0l;
		int i=0;
		for(long old=1l,current=2l; current<4000000; ){	
			i++;
			next= old+current;
			if(i==3){
				i=0;
				sum+=next;
			
			}
			old=current;
			current=next;
			//System.out.println(current);
		}
		System.out.print(sum + "\t");
	}
}
