package com.revature;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Register {

	protected String userName;
	protected String password;
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	protected String username = "nxdkszrk";
	protected String dbpassword = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

	
	public void signUp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========================================");
		System.out.println("To signup Please enter your name and a password for the account");
		System.out.println("========================================");
		System.out.println("\n");

		System.out.println("========================================");
		System.out.println("Enter you name.");
		System.out.println("========================================");

		this.userName = scanner.nextLine();

		System.out.println("========================================");
		System.out.println("Enter you a password.");
		System.out.println("========================================");

		this.password = scanner.nextLine();
		

		try {
			Connection db = DriverManager.getConnection(url, username, dbpassword);
			Statement st = db.createStatement();
			st.executeQuery("INSERT INTO customer (name1,password, balance, approved) values ('" + userName + "','"
					+ password + "',0,'Pending')");

			// rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
		System.out.println("========================================");
		System.out.println("Thank you, please pick an option below.");
		System.out.println("========================================");

	}
}
