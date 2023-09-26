package com.masai.usecases.license;

import java.util.Scanner;

import com.masai.usecases.layers.LicenseDao;
import com.masai.usecases.layers.LicenseDaoImpl;

public class LicenseStatus {
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter aadhar no: ");
		int busno = sc.nextInt();
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		
	    LicenseDao dao = new LicenseDaoImpl();
	    
	    
	    String result = dao.LicenseStatus(aadhar no, name);
	    
     //	    String result = dao.LicenseStatus("Agra", "Mathura", "Aman", 20);
	    
	    System.out.println();
	    
	    System.out.println(result);
	    
	    
		
		
		
	}

}