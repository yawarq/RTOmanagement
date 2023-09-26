package com.masai.usecases.login;

import java.util.Scanner;

import com.masai.usecases.layers.LicenseDao;
import com.masai.usecases.layers.LicenseDaoImpl;

public class adminLogin {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username: ");
		String username = sc.next();
		
		System.out.println("Enter Password: ");
		String password = sc.next();
		
		LicenseDao dao = new LicenseDaoImpl();
		
		String result = dao.adminLogin(username, password);
		
		System.out.println();
		System.out.println(result);
	}
}
