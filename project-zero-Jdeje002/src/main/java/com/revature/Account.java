package com.revature;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class Account {

	protected double balance;

	protected double previousTransaction;
	
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";

	protected String username = "nxdkszrk";

	protected String password = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

	public void showMenu(int id) {

		int option = 0;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome ");


		do {

			System.out.println("========================================");

			System.out.println("Enter a Letter Option");

			System.out.println("========================================");

			System.out.println("1. Check Balance");

			System.out.println("2. Deposit");

			System.out.println("3. Withdraw");

			System.out.println("4. Previous Transaction");

			System.out.println("5. Exit App");

			System.out.println("========================================");

			option = scanner.nextInt();

			System.out.println("\n");
			
			balance = getBalance(id);

			switch (option) {

			case 1:
				
				
				System.out.println("===============================");

				System.out.println("Balance = " + balance);

				System.out.println("===============================");

				System.out.println("\n");

				break;

			case 2:

				System.out.println("===============================");

				System.out.println("Enter Deposit amount: ");

				System.out.println("===============================");

				int amount = scanner.nextInt();

				deposit(amount, id);

				System.out.println("\n");

				System.out.println("========================================");

				System.out.println("Balance is now :" + balance);

				System.out.println("========================================");

				break;

			case 3:

				System.out.println("===============================");

				System.out.println("Enter Withdraw amount ");

				System.out.println("===============================");

				int amount2 = scanner.nextInt();

				withdraw(amount2, id);

				System.out.println("\n");

				System.out.println("========================================");

				System.out.println("Balance is now :" + balance);

				System.out.println("========================================");

				break;

			case 4:

				System.out.println("===============================");

				getPerviousTransaction();

				System.out.println("===============================");

				System.out.println("\n");

				break;

			case 5:

				System.out.println("===============================");
				System.out.println("Goodbye");
				System.out.println("===============================");

				break;

			default:

				System.out.println("Not a valid option.");

			}

		}

		while (option != 5);

		System.out.println("Thank you.");

	}



	
	void deposit(int amount, int id) {

		if (amount != 0) {

			balance = balance + amount;
			
			setBalance(balance, id);

			previousTransaction = amount;
			
			

		}

	}

	// withdraw

	void withdraw(int amount, int id) {

		balance = balance - amount;
		setBalance(balance, id);
		previousTransaction = amount;

	}
	
	void setBalance(double amount, int id) {
		
		try {
			Connection db = DriverManager.getConnection(url, username, password);
			PreparedStatement psSetBalance =db.prepareStatement("UPDATE customer SET balance = ? WHERE customer_id = ?;");
			
			psSetBalance.setDouble(1, amount);
			psSetBalance.setInt(2, id);
			psSetBalance.executeUpdate();

			db.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	double getBalance(int id) {
		double balance = 0.00;
		
		try {

			Connection db = DriverManager.getConnection(url, username, password);

			PreparedStatement psGetBalance = db.prepareStatement("SELECT balance FROM customer WHERE customer_id = ?");
			psGetBalance.setInt(1, id);
			ResultSet rs = psGetBalance.executeQuery();	
			
			while (rs.next()) {

				balance = rs.getDouble(1);
			}

			rs.close();

			db.close();
	} catch (SQLException e) {
		
	}
		
		
		return balance;
	}

	// View

	void getPerviousTransaction() {

		if (previousTransaction > 0) {

			System.out.println("Deposited: " + previousTransaction);

		}

		else if (previousTransaction < 0) {

			System.out.println("Withdrawed : " + Math.abs(previousTransaction));

		}

		else {

			System.out.println("No transaction occured");

		}

	}

}