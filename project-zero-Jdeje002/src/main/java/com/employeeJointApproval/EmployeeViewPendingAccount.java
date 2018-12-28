package com.employeeJointApproval;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Account;

public class EmployeeViewPendingAccount extends Account{
	public void viewPendingApproval() {
		
		System.out.println("========================================");
		System.out.println("The following account needs Arroval");
		System.out.println("========================================");
		System.out.println("\n");
		getStatusArroval();
		EmployeeJointAccount employeeJointAccount = new EmployeeJointAccount();
		employeeJointAccount.EmployeeViewJoint();
	}

	

	public void getStatusArroval() {
		try {

			Connection db = DriverManager.getConnection(super.url, super.username, super.password);

			PreparedStatement psGetBalance = db.prepareStatement(
					"Select customer_id,mainaccountholder,secondaryaccountholder,accountapproved From jointAccount");

			ResultSet rs = psGetBalance.executeQuery();

			while (rs.next()) {

				System.out.print("Customer Identification: " + rs.getInt(1) + " ");
				System.out.print("\t");
				System.out.print("Main Acouunt holder Name: " + rs.getString(2) + " ");
				System.out.print("\t");
				System.out.print("Secandary Acouunt holder Name: " + rs.getString(3) + " ");
				System.out.print("\t");
				System.out.print("Status: " + rs.getString(4) + " ");
				System.out.print("\n");

			}

			rs.close();

			db.close();
		} catch (SQLException e) {

		}
	}
}
