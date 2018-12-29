package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;


public class Login {

	protected String userName;
	protected String passWord;
	protected String comparePassword;
	protected int id;
	protected String approval;
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	protected String usernameDb = "nxdkszrk";
	protected String passwordDb = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";
	
	protected static final Logger log = Logger.getLogger(App.class);


	public void logIn() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("========================================");
		System.out.println("To Log in Enter your name and password");
		System.out.println("========================================");
		
		System.out.println("========================================");
		System.out.println("Please enter your name");
		System.out.println("========================================");

		this.userName = scanner.nextLine();

		System.out.println("========================================");
		System.out.println("Please enter your Password");
		System.out.println("========================================");

		this.passWord = scanner.nextLine();
		
		getApproval();
		
		if(approval.equals("Pending") ){
			System.out.println("========================================");
			System.out.println("Account Has not been approved");
			System.out.println("========================================");
		}else if (approval.equals("Deny")) {
			System.out.println("========================================");
			System.out.println("Account Has not been denied");
			System.out.println("========================================");
		}else {
			loginToAccount();
		}
			
	}
		
	public void getApproval() {
		try {
			Connection db = DriverManager.getConnection(url, usernameDb, passwordDb);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT approved from customer Where name1 = '" + this.userName + "';");
			comparePassword = null;
			
			while (rs.next()) {
				approval = rs.getString(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void loginToAccount() {
		try {
			Connection db = DriverManager.getConnection(url, usernameDb, passwordDb);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT customer_id, password FROM customer Where name1 = '" + this.userName + "';");
			comparePassword = null;
			log.info(this.userName+" Logged into account");
			while (rs.next()) {
				comparePassword = rs.getString(2);
				 id = rs.getInt(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if (comparePassword == null) {
			System.out.println("========================================");
			System.out.println("Username does not exist. Try again.");
			System.out.println("========================================");
		} else if (comparePassword.equals(passWord)) {
			Account account = new Account();
			account.showMenu(id);
		} else {
			System.out.println("========================================");
			System.out.println("Username and Password does not match.");
			System.out.println("========================================");
		}

	
	}
}
