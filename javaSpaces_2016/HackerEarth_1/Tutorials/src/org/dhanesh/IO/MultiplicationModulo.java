package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiplicationModulo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String[] numbers = br.readLine().split(" ");
		double sum = 1;
		double modulo = Math.pow(10, 9) + 7;
		for(int i=0; i<len; i++){
			int num = Integer.parseInt(numbers[i]);
			sum = (sum*num)% modulo;
		}
		
		System.out.println((int)sum);
	}
}
