package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

	private String userName;
	private String passWord;
	private String comparePassword;

	public void logIn() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("========================================");
		System.out.println("Enter you name");
		System.out.println("========================================");

		this.userName = scanner.nextLine();

		System.out.println("========================================");
		System.out.println("Enter you a Password");
		System.out.println("========================================");

		this.passWord = scanner.nextLine();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
		String username = "nxdkszrk";
		String password = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

		try {
			Connection db = DriverManager.getConnection(url, username, password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT password FROM customer Where name = '" + this.userName + "';");
			comparePassword = null; 
			
			while (rs.next()) {
				comparePassword = rs.getString(1);

//	             System.out.println(rs.getString(2));
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

		
		if( comparePassword == null) {
			System.out.println("========================================");
			System.out.println("Username does not exist. Try again.");
			System.out.println("========================================");
		} else if(comparePassword.equals(passWord)) {
			Account account = new Account();
			account.showMenu();
		} else {
			System.out.println("========================================");
			System.out.println("Username and Password does not match.");
			System.out.println("========================================");
		}
		
		
	}

}
