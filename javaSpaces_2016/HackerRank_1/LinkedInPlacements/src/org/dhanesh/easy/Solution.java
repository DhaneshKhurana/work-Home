package org.dhanesh.easy;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arSize = sc.nextInt();
		int divisor = sc.nextInt();
		int[] nums = new int[arSize];
		int count=0;
		for(int i =0; i<arSize; i++){
			nums[i] = sc.nextInt();
		}
		for(int i=0; i<arSize-1;i++){
			for(int j=i+1; j<arSize;j++){
				if( (nums[i]+nums[j])%divisor==0){
					count++;
				}
			}
		}
		System.out.println(count);
		
	}
}
