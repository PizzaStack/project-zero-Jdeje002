package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.Account;

public class JointLogIn extends JointRegister {
	
	private String comparePassword;
	private String tryPassword;
	private int jointAccountId;
	
	
	public void jointLogIn() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("========================================");
		System.out.println("To Log in Enter your name and password");
		System.out.println("========================================");

		System.out.println("========================================");
		System.out.println("Please enter your Account Id");
		System.out.println("========================================");

		super.jointAccountId = Integer.parseInt(scanner.nextLine());

		System.out.println("========================================");
		System.out.println("Please enter your Password");
		System.out.println("========================================");

		tryPassword = scanner.nextLine();
		
		checkJointaccount();
		CheckPassword();
	}

	public void checkJointaccount() {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("Select password, customer_id From Jointaccount where customer_id ="
					+ super.jointAccountId + "");
			
			comparePassword = null;
			while (rs.next()) {
				comparePassword = rs.getString(1);
				jointAccountId = rs.getInt(2);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void CheckPassword() {
		
		if (comparePassword == null) {
			System.out.println("========================================");
			System.out.println("Username does not exist. Try again.");
			System.out.println("========================================");
		} else if (comparePassword.equals(this.tryPassword)) {
			JointAccount jointAccount = new JointAccount();
			jointAccount.showMenu(jointAccountId);
			
			System.out.println("works");
		} else {
			
			System.out.println("========================================");
			System.out.println("Username and Password does not match.");
			System.out.println("========================================");
		}
	}
}
