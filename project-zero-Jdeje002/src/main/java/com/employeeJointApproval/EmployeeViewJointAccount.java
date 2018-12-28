package com.employeeJointApproval;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.employee.EmployeeAccount;
import com.revature.Account;

public class EmployeeViewJointAccount extends Account {
	
	public void getAccounts() {
		
		try {

			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			PreparedStatement psGetBalance = db.prepareStatement("Select * From jointaccount");
			ResultSet rs = psGetBalance.executeQuery();

			while (rs.next()) {

				System.out.print("Main Account Holder: " + rs.getString(2) + " ");
				System.out.print("& ");
				System.out.print("Secandary Account Holder: " + rs.getString(3) + " ");
				System.out.print("\t");
				System.out.print("Balance: " + rs.getDouble(5) + " ");
				System.out.print("Status: " + rs.getString(6) + " ");
				System.out.print("\n");
			}

			rs.close();

			db.close();
		} catch (SQLException e) {

		}
		System.out.println("\n");
		EmployeeJointAccount employeeJointAccount = new EmployeeJointAccount();
		employeeJointAccount.EmployeeViewJoint();
	}
}
