package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Account;

public class ViewEmployeeApproval extends Account {
	
	public void viewPendingApproval() {
		EmployeeAccount employeeAccount = new EmployeeAccount();
		System.out.println("========================================");
		System.out.println("The following account needs Arroval");
		System.out.println("========================================");
		System.out.println("\n");
		getStatusArroval();
		employeeAccount.showEmployeeAccountMenu();
	}
	
	public void getStatusArroval() {
		try {

			Connection db = DriverManager.getConnection(super.url, super.username, super.password);

			PreparedStatement psGetBalance = db.prepareStatement("Select customer_id,name1,approved From customer");

			ResultSet rs = psGetBalance.executeQuery();

			while (rs.next()) {
				
				
				System.out.print("Customer Identification: " + rs.getInt(1) + " ");
				System.out.print("Customer Name: " + rs.getString(2) + " ");
				System.out.print("Status: " + rs.getString(3) + " ");
				System.out.print("\n");

			}

			rs.close();

			db.close();
		} catch (SQLException e) {

		}
	}
	
}
