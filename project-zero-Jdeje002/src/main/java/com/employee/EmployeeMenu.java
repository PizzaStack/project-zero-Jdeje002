package com.employee;

import java.util.Scanner;

public class EmployeeMenu {

	public void showEmployeeMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=======================================");
		System.out.println("Welcome ");

		System.out.println("\n");

		System.out.println("=======================================");
		System.out.println("1. Sign in");
		System.out.println("2. Register new account.");

		System.out.println("3. Exit App");
		System.out.println("=======================================");

		int option = 0;

		option = scanner.nextInt();

		switch (option) {
		case 1:
			EmployeeLogIn employeeLogIn = new EmployeeLogIn();
			employeeLogIn.employeeLogIn();
			break;
		case 2:
			EmployeeRegister employeeRegister = new  EmployeeRegister();
			employeeRegister.employeeRegister();
			break;
		case 3:
			System.out.println("========================================");
			System.out.println("Thank you, Signing out");
			System.out.println("========================================");
			break;
		default:
			System.out.println("========================================");
			System.out.println("Not a valid option, Please try again");
			System.out.println("========================================");
			break;
		}
	}
}
