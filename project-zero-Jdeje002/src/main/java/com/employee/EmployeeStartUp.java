package com.employee;

import java.util.Scanner;

import com.revature.Login;
import com.revature.Register;

public class EmployeeStartUp {
	
	
	public void startUpEmployee() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("=======================================");
		System.out.println("Welcome ");

		System.out.println("\n");

		System.out.println("=======================================");
		System.out.println("1. Sign in.");
		System.out.println("2. Register new account.");

		System.out.println("3. Exit App");
		System.out.println("=======================================");
		int option = 0;

		option = scanner.nextInt();

		switch (option) {
		// Sign in
		case 1:
	
			break;
			
		// register
		case 2:
			
			break;

		}
	}

}
