package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IntergerArray {

	public static void main(String args[] ){
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	br.readLine();
	    	String line;
	    	Integer a;
	    	while( (line= br.readLine())!=null){
	    		a = Integer.parseInt(line);
	    		System.out.println(a-1);
	    	}
		}catch (Exception e) {
			// TODO: handle exception
		}
    }
}
