package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	protected String userName;
	protected String passWord;
	protected String comparePassword;
	protected int id;
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	protected String usernameDb = "nxdkszrk";
	protected String passwordDb = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

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

		
		

		try {
			Connection db = DriverManager.getConnection(url, usernameDb, passwordDb);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT customer_id, password FROM customer Where name1 = '" + this.userName + "';");
			comparePassword = null;

			while (rs.next()) {
				comparePassword = rs.getString(2);
				 id = rs.getInt(1);
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
