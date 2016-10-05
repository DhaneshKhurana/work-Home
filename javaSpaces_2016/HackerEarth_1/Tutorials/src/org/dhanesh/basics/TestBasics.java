package org.dhanesh.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestBasics {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int count=0;
		String[] nums=null;
		try {
			nums = reader.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(nums!=null){
			int start = Integer.parseInt(nums[0]);
			int end = Integer.parseInt(nums[1]);
			int divisor = Integer.parseInt(nums[2]);
			
			for(int i=start;i<=end;i++){
				if(i%divisor==0){
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}
