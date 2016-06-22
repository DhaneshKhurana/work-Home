package regularExpressions;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

    public static void main(String[] args){
    	 while (true) {
        	Scanner obj = new Scanner(System.in);
        	Pattern pattern = Pattern.compile(obj.next());
        	//obj.close();
        	System.out.println("Enter the text to be searched");
        	Scanner obj2 = new Scanner(System.in);
        	String Text = obj2.next();
            Matcher matcher = pattern.matcher(Text);
            boolean found = false;
            while (matcher.find()) {
                System.out.println("I found the text " + matcher.group() + " starting at " +  matcher.start() + " index and ending at index "+matcher.end());
                found = true;
            }
            if(!found){
                System.out.println("No match found.%n");
            }
        }
    }

}

