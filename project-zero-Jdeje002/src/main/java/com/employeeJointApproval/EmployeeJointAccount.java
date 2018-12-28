package com.employeeJointApproval;

import java.util.Scanner;

public class EmployeeJointAccount {
	
	public void EmployeeViewJoint() {
		System.out.println("========================================");
		System.out.println("Please pick the following");
		System.out.println("========================================");
		System.out.println("\n");
		
		System.out.println("========================================");
		System.out.println("1.View Joint accounts");
		System.out.println("2.View Pending Joint Accounts");
		System.out.println("3.Approve/Deny Pending Joint accounts");
		System.out.println("4.Delete Account");
	
		System.out.println("5.Exit");
		
		System.out.println("========================================");
		System.out.println("\n");
		
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		option = scanner.nextInt();
		
		switch(option) {
		case 1:
			EmployeeViewJointAccount employeeViewJointAccount = new EmployeeViewJointAccount();
			employeeViewJointAccount.getAccounts();
			break;
		case 2:
			EmployeeViewPendingAccount  employeeViewPendingAccount  = new EmployeeViewPendingAccount ();
			employeeViewPendingAccount.viewPendingApproval();
			break;
		case 3:
			EmployeeJointApproval employeeJointApproval = new EmployeeJointApproval();
			employeeJointApproval.approvalProcess();
			break;
        case 4:
        	EmployeeDeleteJointAccount employeeDeleteJointAccount = new EmployeeDeleteJointAccount();
        	employeeDeleteJointAccount.deleteCustomerAccount();
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
