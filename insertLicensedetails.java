package com.masai.usecases.license;

import java.util.Scanner;

import com.masai.usecases.layers.LicenseDao;
import com.masai.usecases.layers.LicenseDaoImpl;

public class IntsertLicenseDetails {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter user name: ");
		String user name = sc.next();
		
		System.out.println("Enter DOB: ");
		String dob = sc.next();
		
		System.out.println("Enter address: ");
		String address = sc.next();
		
		System.out.println("Enter Vehicle Type: ");
		String vehicletype = sc.next();
		
		System.out.println("Enter License id: ");
		int License id = sc.nextInt();
		
		System.out.println("Enter issue date: ");
		String issue date = sc.next();
		
		System.out.println("Enter valid date: ");
		String valid date = sc.next();
		
		
		LicenseDao dao = new LicenseDaoImpl();
		
		String result = dao.insertLicenseDetails(user name, DOB, address, vehicletype, License id, issue date, valid date);
		
		System.out.println(result);
		
		
		
	}
	

}