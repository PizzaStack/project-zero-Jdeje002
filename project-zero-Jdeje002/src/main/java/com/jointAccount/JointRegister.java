package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JointRegister {
	// db account info
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	protected String dbUserName = "nxdkszrk";
	protected String dbPassword = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

	// users
	protected String mainAccountHolder;
	protected String mainAccountHolderId;
	protected String secondaryAccountHolder;
	protected String secondaryAccountHolderId;
	protected String userName;
	protected String passWord;
	protected Double Balance;

	public void startUp() {
		// scanner
		Scanner scanner = new Scanner(System.in);

		System.out.println("===============================================");
		System.out.println("To regisiser for a joint account");
		System.out.println("Enter in the Account Id for Main Account.");
		System.out.println("===============================================");
		System.out.println("\n");

		this.mainAccountHolderId = scanner.nextLine();
		setMainAccountHolderName(); 

		System.out.println("===============================================");

		System.out.println("Enter in the Account Id for Secandary Account.");
		System.out.println("===============================================");
		System.out.println("\n");

		this.secondaryAccountHolderId = scanner.nextLine();
		SetSecondaryAccountHolder();

	}

	public void setMainAccountHolderName() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT name1 FROM customer Where customer_id = '" + this.mainAccountHolderId + "';");

			while (rs.next()) {

				mainAccountHolder = rs.getString(1);
//	             System.out.println(comparePassword);
//	             System.out.print("Column 2 returned ");
//	             System.out.println(rs.getString(3));
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void SetSecondaryAccountHolder() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT name1 FROM customer Where customer_id = '" + this.secondaryAccountHolderId + "';");

			while (rs.next()) {

				secondaryAccountHolder = rs.getString(1);
//	             System.out.println(comparePassword);
//	             System.out.print("Column 2 returned ");
//	             System.out.println(rs.getString(3));
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
