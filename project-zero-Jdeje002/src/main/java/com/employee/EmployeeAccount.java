package com.employee;

import java.util.Scanner;

public class EmployeeAccount {
	
		public void showEmployeeAccountMenu() {
			
			
			System.out.println("========================================");
			System.out.println("Please pick the following");
			System.out.println("========================================");
			System.out.println("\n");
			
			System.out.println("========================================");
			System.out.println("1.View all accounts");
			System.out.println("2.View Pending Accounts");
			System.out.println("3.Approve/Deny Pending accounts");
			System.out.println("4.Delete Account");
		
			System.out.println("4.Exit");
			
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
				ViewEmployeeApproval Ea = new ViewEmployeeApproval();
				Ea.viewPendingApproval();
				break;
			case 3:
	
				EmployeeApproval ap = new EmployeeApproval();
				
				ap.approvalProcess();
				
				break;
			case 4:
				EmployeeDeleteAccount EDA = new EmployeeDeleteAccount();
				EDA.deleteCustomerAccount(); 
				break;
			case 5:
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
