package abstractclasses;

public class BaseOne extends AbstractOne {
	
	private int i;
	
	public BaseOne() {
	this.i = super.i;
	}
	
	public static void main(String[] args){
		BaseOne b = new BaseOne();
		System.out.println(b.i);
	}
}
