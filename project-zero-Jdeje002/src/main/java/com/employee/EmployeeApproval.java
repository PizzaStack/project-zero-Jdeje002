package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Account;
import com.revature.App;

public class EmployeeApproval extends Account {

	protected int Id;
	static final Logger log = Logger.getLogger(App.class);
	public void approvalProcess() {
		
		Scanner scanner = new Scanner(System.in);
		EmployeeAccount employeeAccount = new EmployeeAccount();
		System.out.println("========================================");
		System.out.println("Enter Cutomer Id for approval process.");
		System.out.println("========================================");
		Id = scanner.nextInt();
		getId();
		approveOrDeny();
		employeeAccount.showEmployeeAccountMenu();

	}

	public void getId() {
		try {
			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery("Select customer_id from customer where customer_id =" + Id);
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
			log.info("user Id: "+ Id + " has been approved ");
			break;
		case 2:
			conntectDbforapproval("Deny");
			log.info("User id: "+Id+" has been Denied");
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
			st.executeUpdate("Update customer  set approved = '" +status+"'  where customer_id =" + Id);
			
			st.close();
			
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
	}
}
