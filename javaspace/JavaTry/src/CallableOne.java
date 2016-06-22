import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;


public class CallableOne extends AbSuper implements Callable<String>{
	
	private List<String[]> taskList;
	protected HashMap resultMap;
	
	public List<String[]> getTaskList(){
		return taskList;
	}
	
	public String call(){
		
		for(String[] task : getTaskList()){
			
			getService().submit(new SubCallableOne(task));
		}
		
		return "done with Callable One";
	}
}
