package com.revature;

import java.util.Scanner;

public class BankAccount {
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	
	protected BankAccount(String cname, String cId)
	{
		customerName = cname;
		customerId = cId;
	}
	
	
	 protected void deposit(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = amount;
			
		}
	 }
	 
	 
	 void withdraw (int amount) {
		 balance = balance - amount;
		 previousTransaction = -amount;
	 }
	 
	 
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
		 char option = '\0';
		 Scanner scanner = new Scanner(System.in);
		 
		 System.out.println("Welcome " + customerName);
		 System.out.println("You Quique Id is : " + customerId);
		 System.out.println("\n");
		 
		 System.out.println("A. Check Balance" );
		 System.out.println("B. Deposit");
		 System.out.println("C. Withdraw");
		 System.out.println("D. Previous Transaction");
		 System.out.println("D. Exit App");
		 
		 do 
		 {
			 System.out.println("========================================");
			 System.out.println("Enter a Letter Option");
			 System.out.println("========================================");
	
			 option = scanner.next().charAt(0);
			 System.out.println("\n");
			 
			 
			 switch(option) {
			 
			 case 'A':
				 System.out.println("===============================");
				 System.out.println("Balance = "+ balance);
				 System.out.println("===============================");
				 System.out.println("\n");
				 break;
			 case 'B':
				 System.out.println("===============================");
				 System.out.println("Enter Deposit amount "+ balance);
				 System.out.println("===============================");
				
				 int amount = scanner.nextInt();
				 deposit(amount);
				 
				 System.out.println("\n");
				 break;
				 
			 case 'C' : 
				 System.out.println("===============================");
				 System.out.println("Enter Withdraw amount ");
				 System.out.println("===============================");
				 
				 int amount2 = scanner.nextInt();
				 withdraw(amount2);
				 System.out.println("\n");
				 break;
			 case 'D' : 
				 System.out.println("===============================");
				 getPerviousTransaction();
				 System.out.println("===============================");
				 System.out.println("\n");
				 break;
			 case 'E':
				 System.out.println("===============================");
				 break;
			
			default:
				System.out.println("Not a valid option.");
			
			 }
			
				 
			 
		 }
		 while(option != 'E');
		 System.out.println("Thank you.");
	 }
	 
	
}
