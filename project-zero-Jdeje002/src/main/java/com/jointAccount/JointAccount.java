package com.jointAccount;

import java.util.Scanner;

public class JointAccount {

	protected double balance;
	protected int id;

	public void showMenu(int jointAccountId) {
		int option = 0;
		

		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome ");

		System.out.println("========================================");
		System.out.println("Enter a Letter Option");
		System.out.println("========================================");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit App");
		System.out.println("========================================");
		System.out.println("\n");
		

		option = scanner.nextInt();

		System.out.println("\n");
		
			switch (option) {
			case 1:
				// Check Balance
				JointCheckBalance jointCheckBalance = new JointCheckBalance();
				jointCheckBalance.getBalance(jointAccountId);
				break;
			case 2:
				// Deposit
				JointDeposit jointDeposit = new JointDeposit();
				jointDeposit.depositIntoBalance(jointAccountId);
				System.out.println("========================================");
				System.out.println("Goodbye");
				System.out.println("========================================");
				break;
			case 3:
				// Withdraw
				break;
			case 4:
				System.out.println("========================================");
				System.out.println("Goodbye");
				System.out.println("========================================");
				System.out.println("\n");
				break;
			default:
				System.out.println("========================================");
				System.out.println("Not a vaild entry");
				System.out.println("========================================");
				System.out.println("\n");
				break;
			}
	}
}

