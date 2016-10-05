package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StopAt42 {

	public static void main(String[] args) {
		try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in))) {
			while(br!=null){
				int num = Integer.parseInt(br.readLine());
				if(num==42){
					break;
				}
				System.out.println(num);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
