package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
	
    public static void main(String args[] ) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        line = br.readLine();
        System.out.println(2*N);
        System.out.println(line);
    }
}
