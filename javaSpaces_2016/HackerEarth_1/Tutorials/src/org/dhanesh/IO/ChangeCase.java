package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChangeCase {
	
	public static void main(String args[] ) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();
        
        for(int i=0; i<line.length; i++){
        	char symbol = line[i];
        	if(symbol>='A' && symbol<='Z'){
        		line[i] +=32; 
        	}else if(symbol>='a' && symbol<='z'){
        		line[i]-=32;
        	}
        }
        
        System.out.println(new String(line));
    }
}
