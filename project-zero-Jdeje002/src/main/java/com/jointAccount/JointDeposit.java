package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JointDeposit extends JointRegister {

	protected double oldBalance;
	protected double newBalance;
	protected double userDeposit;
	
	Scanner scanner = new Scanner(System.in);

	public void depositIntoBalance(int jointAccountId) {
		
		System.out.println("===============================");

		System.out.println("Enter Deposit amount: ");

		System.out.println("===============================");
		
		this.userDeposit = scanner.nextDouble();
		connectDb(jointAccountId);
		newBalance = oldBalance + userDeposit;
		
		setNewBalance(jointAccountId,newBalance);
		
		System.out.println("\n");

		System.out.println("========================================");

		System.out.println("Balance is now :" + newBalance);

		System.out.println("========================================");
	}

	public void connectDb(int jointAccountId) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT balance FROM jointaccount Where customer_id = '" + jointAccountId + "';");

			while (rs.next()) {

				oldBalance = rs.getDouble(1);

			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public void setNewBalance(double jointAccountId, double newBalance) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			st.executeUpdate("Update jointaccount Set balance ="+newBalance+" where customer_id =" + jointAccountId+";");

			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
