package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PalindromStringTest {

	public static void main(String[] args) {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			char[] line = br.readLine().toCharArray();
	    	int len = line.length;
	    	boolean isPalindrome = true;
			for(int i=0; i<len/2;i++){
				if(line[i]!=line[len-1-i]){
					isPalindrome = false;
					break;
				}
			}
			if(!isPalindrome){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
	    	
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
