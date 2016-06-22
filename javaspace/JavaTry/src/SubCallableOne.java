import java.util.List;


public class SubCallableOne extends CallableOne {

	String[] task;
	
	public SubCallableOne(String[] task) {
		this.task = task;
	}
	
	public String call(){
		//do what you are suppose to do
		//and then access and populate "resultMap" fom superclass
		return "done with subCallableOne";
	}
}
