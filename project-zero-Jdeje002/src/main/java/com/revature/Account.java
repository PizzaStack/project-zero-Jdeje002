package com.revature;

import java.util.Scanner;

public class Account {
	
	double balance;
	double previousTransaction;
	
	// deposit
	 void deposit(int amount) {
			if(amount != 0) {
				balance = balance + amount;
				previousTransaction = amount;
				
			}
		 }
	 // withdraw
	 void withdraw (int amount) {
		 balance = balance - amount;
		 previousTransaction = amount;
	 }
	 // View 
	 void getPerviousTransaction() {
		 if (previousTransaction > 0) {
			 System.out.println("Balance: " + previousTransaction);
		 }
		 else if (previousTransaction < 0 ) {
			 System.out.println("Withdrawed : " + Math.abs(previousTransaction));
		 }
		 else {
			 System.out.println("No transaction occured");
		 }
	 }
	 
	 void showMenu() {
		 int option = 0;
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Welcome ");
		 System.out.println("==========================");
		 System.out.println("\n");
		 
		 System.out.println("1. Check Balance" );
		 System.out.println("2. Deposit");
		 System.out.println("3. Withdraw");
		 System.out.println("4. Previous Transaction");
		 System.out.println("5. Exit App");
		 
		 do 
		 {
			 System.out.println("========================================");
			 System.out.println("Enter a Letter Option");
			 System.out.println("========================================");
	
			 option = scanner.nextInt();
			 
			 System.out.println("\n");
			 
			 
			 switch(option) {
			 
			 case 1:
				 System.out.println("===============================");
				 System.out.println("Balance = "+ balance);
				 System.out.println("===============================");
				 System.out.println("\n");
				 break;
			 case 2:
				 System.out.println("===============================");
				 System.out.println("Enter Deposit amount "+ balance);
				 System.out.println("===============================");
				
				 int amount = scanner.nextInt();
				 deposit(amount);
				 
				 System.out.println("\n");
				 break;
				 
			 case 3 : 
				 System.out.println("===============================");
				 System.out.println("Enter Withdraw amount ");
				 System.out.println("===============================");
				 
				 int amount2 = scanner.nextInt();
				 withdraw(amount2);
				 System.out.println("\n");
				 break;
			 case 4 : 
				 System.out.println("===============================");
				 getPerviousTransaction();
				 System.out.println("===============================");
				 System.out.println("\n");
				 break;
			 case 5:
				 System.out.println("===============================");
				 break;
			
			default:
				System.out.println("Not a valid option.");
			
			 }
			
				 
			 
		 }
		 while(option != 5);
		 System.out.println("Thank you.");
	 }
	 
}
