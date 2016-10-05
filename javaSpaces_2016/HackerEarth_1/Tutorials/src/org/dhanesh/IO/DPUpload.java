package org.dhanesh.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DPUpload {

	public static void main(String[] args) {
		int requiredSize=0;
		int numOfPhotos=0;
		try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in))) {
			requiredSize = Integer.parseInt(br.readLine());
			numOfPhotos = Integer.parseInt(br.readLine());
			for(int i=0; i<numOfPhotos;i++){
				String[] dims = br.readLine().split(" ");
				int w = Integer.parseInt(dims[0]);
				int h = Integer.parseInt(dims[1]);
				
				if(w<requiredSize || h<requiredSize){
					System.out.println("UPLOAD ANOTHER");
				}else if (w!=h) {
					System.out.println("CROP IT");
				}else{
					System.out.println("ACCEPTED");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
