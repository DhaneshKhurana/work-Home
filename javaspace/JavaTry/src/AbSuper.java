import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public abstract class AbSuper {
	private static HashMap hmap; 
	private static CompletionService<String> service;
	private static int maxThreads = 10;
	
	static{
		initializeMap();
	}
	 public static void initializeMap(){
		 //load from file
	 }
	
	public HashMap getmap(){
		return hmap;
	}
	
	public void commonMethodOne(){
		//do something
	}
	
	public static CompletionService<String> getService(){
		ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
		service = new ExecutorCompletionService<String>(executor);
		return service;
	}
}


