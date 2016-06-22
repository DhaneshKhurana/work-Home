import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;


public class CallableThread implements Callable<String>{

	public String call(){
		
		HashMap<String, String> mapTask = StaticClass.gethMap();
		List<String> taskOne =StaticClass.getListOne();
		
		for(String temp : taskOne){
			//do what you are suppose to do
		}
		for(String key : mapTask.keySet()){
			//do what you are supposed to do
		}
		return "Done with CallableThread";
	}
}
