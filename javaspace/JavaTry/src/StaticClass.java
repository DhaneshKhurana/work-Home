import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class StaticClass {
	private static List<String> ListOne;
	private static List<String> listTwo;
	private static HashMap<String, String> hMap;
	
	public final static String b = "ahmed";
	
	
	static{
		//initialize list and maps by reading from file
		ListOne = new ArrayList<String>();
	}
	
	
	public static List<String> getListOne() {
		return ListOne;
	}
	public static String getString() {
		return "\\" + b;
	}
	public static List<String> getListTwo() {
		return listTwo;
	}
	public static HashMap<String, String> gethMap() {
		return hMap;
	}
	
	public static void main(String[] args){
		System.out.println();
		
		
		Set<String> a = new HashSet<>();
		
		Map<String, String> b  = new ConcurrentHashMap<>();
		
		Map<String, String>c  = new HashMap<String, String>();
	
	
	
	
	}
	
}
