package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.employeeJointApproval.EmployeeJointAccount;
import com.revature.Account;
import com.revature.App;
import com.revature.Login;

public class EmployeeLogIn extends Login{

	static final Logger log = Logger.getLogger(App.class);
	public void employeeLogIn() {
		
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("========================================");
		System.out.println("To Log in Enter your name and password");
		System.out.println("========================================");
		
		System.out.println("========================================");
		System.out.println("Please enter your name");
		System.out.println("========================================");
		System.out.println("\n");
		super.userName = scanner.nextLine();

		System.out.println("========================================");
		System.out.println("Please enter your Password");
		System.out.println("========================================");
		System.out.println("\n");

		super.passWord = scanner.nextLine();
		
		connectToEmployeeDb();
		
	}
	
	public void connectToEmployeeDb() {
		try {
			Connection db = DriverManager.getConnection(super.url, super.usernameDb, super.passwordDb);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("SELECT customer_id, password FROM employee Where name1 = '" + super.userName + "';");
			super.comparePassword = null;
			log.info(super.userName+" Logged into account");
			while (rs.next()) {
				super.comparePassword = rs.getString(2);
				super.id = rs.getInt(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if (super.comparePassword == null) {
			System.out.println("========================================");
			System.out.println("Username does not exist. Try again.");
			System.out.println("========================================");
		} else if (super.comparePassword.equals(super.passWord)) {
			int option;
			Scanner scanner = new Scanner(System.in);
			System.out.println("========================================");
			System.out.println("1. View Checking accounts.");
			System.out.println("2. View Joint Account.");
			System.out.println("========================================");
			
			option = scanner.nextInt();
			switch(option) {
			case 1:
				EmployeeAccount ea = new EmployeeAccount();
				ea.showEmployeeAccountMenu();
				break;
			case 2:
				EmployeeJointAccount employeeJointAccount = new EmployeeJointAccount();
				employeeJointAccount.EmployeeViewJoint();
				break;
			}
			
			
		} else {
			System.out.println("========================================");
			System.out.println("Username and Password does not match.");
			System.out.println("========================================");
		}
	}
	
	
	
}
