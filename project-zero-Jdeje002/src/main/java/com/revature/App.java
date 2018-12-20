package com.revature;

import java.io.IOException;
import java.util.Scanner;

import com.employee.EmployeeMenu;
import com.employee.EmployeeRegister;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException {
		// scanner
		Scanner scanner = new Scanner(System.in);
		// Switch case for Employee, customer and admin
		System.out.println("=======================================");
		System.out.println("1. Customer Login ");
		System.out.println("2. Administrator Login");

		System.out.println("3. Exit App");
		System.out.println("=======================================");
		int option = 0;
		option = scanner.nextInt();

		switch (option) {

		case 1:
			StartUp startup = new StartUp();
			startup.startUp();
			break;
		case 2:
			EmployeeMenu em = new EmployeeMenu();
			em.showEmployeeMenu();
			break;
		default:
			System.out.println("Sorry was not an option.");
			break;
		}

//    	

	}
}
