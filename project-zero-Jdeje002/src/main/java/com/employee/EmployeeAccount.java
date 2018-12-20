package com.employee;

import java.util.Scanner;

public class EmployeeAccount {
	
		public void showEmployeeAccountMenu() {
			
			System.out.println("========================================");
			System.out.println("Wellcome back!");
			System.out.println("========================================");
			System.out.println("\n");
			
			System.out.println("========================================");
			System.out.println("Please pick the following");
			System.out.println("========================================");
			System.out.println("\n");
			
			System.out.println("========================================");
			System.out.println("1.View all accounts");
			System.out.println("2.View Pending Accounts");
			System.out.println("3.Exit");
			
			System.out.println("========================================");
			System.out.println("\n");
			
			Scanner scanner = new Scanner(System.in);
			int option = 0;
			option = scanner.nextInt();
			
			switch(option) {
			
			case 1:
				EmployeeCheckAccounts ECA = new EmployeeCheckAccounts();
				ECA.getAccounts();
				break;
			
			case 2:
				break;
			
			case 3:
				System.out.println("========================================");
				System.out.println("Exiting Program.");
				System.out.println("========================================");
				break;
			default:
				System.out.println("========================================");
				System.out.println("Invalid Entry");
				System.out.println("========================================");
				break;
			}
			
			
		}
}
