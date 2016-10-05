package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Factorial {

	public static void main(String[] args) {
		int num=0;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			num = Integer.parseInt(br.readLine());
		}catch(Exception e){
			e.printStackTrace();
		}
		int ans=1;
		while(num>0){
			ans*=num;
			num--;
		}
		System.out.println(ans);
	}
}
