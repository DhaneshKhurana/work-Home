package com.dhanesh.main;

import java.util.Scanner;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

public class IPLocationFinder {

	public static void main(String[] args) {
		
		
		//Let us create the object of service main
		GeoIPService serviceMain = new GeoIPService();
		//Let us get the port main from the service
		GeoIPServiceSoap serviceSoap =serviceMain.getGeoIPServiceSoap();
		
		System.out.println("Enter the ip address to know the location,");
		System.out.println("To exit enter 0");
		Scanner sc = new Scanner(System.in);
		while(true){
			String ip = sc.nextLine();
			if(ip!=null && !ip.isEmpty()){
				GeoIP geoLoc = serviceSoap.getGeoIP(ip);
				System.out.println("the location of the ip " + ip + " is :: " + geoLoc.getCountryName());
				
			}
			
		}

	}

}
