package com.employeeJointApproval;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.employee.EmployeeAccount;
import com.revature.Account;

public class EmployeeJointApproval extends Account {
	protected int Id;

	public void approvalProcess() {
		
		Scanner scanner = new Scanner(System.in);
      
		System.out.println("========================================");
		System.out.println("Enter Cutomer Id for approval process.");
		System.out.println("========================================");
		Id = scanner.nextInt();
		getId();
		approveOrDeny();
		
		EmployeeJointAccount employeeJointAccount = new EmployeeJointAccount();
		employeeJointAccount.EmployeeViewJoint();
	}
	
	public void getId() {
		try {
			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("Select customer_id from jointaccount where customer_id =" + Id);
			while (rs.next()) {
				Id = rs.getInt(1);
				
			}
			st.close();
			rs.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
	}
	
	public void approveOrDeny() {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		
		System.out.println("========================================");
		System.out.println("1. Approved");
		System.out.println("2. Deny");
		System.out.println("3. Exit");

		System.out.println("========================================");
		option = scanner.nextInt();
		// switch case
		switch (option) {
		case 1:
			conntectDbforapproval("Approved");
			break;
		case 2:
			conntectDbforapproval("Deny");
			break;
		case 3:
			System.out.println("========================================");
			System.out.println("Good-Bye");
			System.out.println("========================================");
			break;
		}
	}
	
	public void conntectDbforapproval(String status) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			Statement st = db.createStatement();
			st.executeUpdate("Update jointaccount set accountapproved = '" +status+"'  where customer_id =" + Id);
			
			st.close();
			
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
	}
}
