package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
	
	double balance;
	double previousTransaction;
	
	
	 
	 void showMenu(int id) {
		 
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
		 
		 do {
			 System.out.println("========================================");
			 System.out.println("Enter a Letter Option");
			 System.out.println("========================================");
			 System.out.println("1. Check Balance" );
			 System.out.println("2. Deposit");
			 System.out.println("3. Withdraw");
			 System.out.println("4. Previous Transaction");
			 System.out.println("5. Exit App");
			 System.out.println("========================================");
	
			 option = scanner.nextInt();
			 
			 System.out.println("\n");
			 
			 
			 switch(option) {
			 
			 case 1:
				 System.out.println("===============================");
				 System.out.println("Balance = "+balance);
				 System.out.println("===============================");
				 System.out.println("\n");
				 break;
			 case 2:
				 System.out.println("===============================");
				 System.out.println("Enter Deposit amount: " );
				 System.out.println("===============================");
				
				 int amount = scanner.nextInt();
				 deposit(amount, id);
				 
				 System.out.println("\n");
				 
				 System.out.println("========================================");
				 System.out.println("Balance is now :"+ balance);
				 System.out.println("========================================");
					
				 break;
				 
			 case 3 : 
				 System.out.println("===============================");
				 System.out.println("Enter Withdraw amount ");
				 System.out.println("===============================");
				 
				 int amount2 = scanner.nextInt();
				 withdraw(amount2,id);
				 System.out.println("\n");
				 System.out.println("========================================");
				 System.out.println("Balance is now :"+ balance);
				 System.out.println("========================================");
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
			
			// db  	
			 try {
		         Class.forName("org.postgresql.Driver");
		     }
		     catch (java.lang.ClassNotFoundException e) {
		         System.out.println(e.getMessage());
		     }

		     String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
		     String username = "nxdkszrk";
		     String password = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

		     try {
		         Connection db = DriverManager.getConnection(url, username, password);
		         Statement st = db.createStatement();
		         st.executeQuery("UPDATE customer "
		         		+ "SET balance = " +balance
		         		+ " WHERE customer_id = "+id+";");
		         
		         
		         st.close();
		         // needed
		         db.close();
		         }
		     catch (java.sql.SQLException e) {
		         
		     }
			 
		 }
		 while(option != 5);
		 System.out.println("Thank you.");
	 }

		// deposit
		 void deposit(int amount, int id) {
				if(amount != 0) {
					balance = balance + amount;
					previousTransaction = amount;
					
				}
			 }
		 // withdraw
		 void withdraw (int amount, int id) {
			 balance = balance - amount;
			 previousTransaction = amount;
		 }
		 // View 
		 void getPerviousTransaction() {
			 if (previousTransaction > 0) {
				 System.out.println("Deposited: " + previousTransaction);
			 }
			 else if (previousTransaction < 0 ) {
				 System.out.println("Withdrawed : " + Math.abs(previousTransaction));
			 }
			 else {
				 System.out.println("No transaction occured");
			 }
		 }
}