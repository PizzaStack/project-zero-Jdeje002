package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Account;

public class EmployeeCheckAccounts extends Account {
	
	public void getAccounts() {
		EmployeeAccount employeeAccount = new EmployeeAccount();
		try {

			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			PreparedStatement psGetBalance = db.prepareStatement("Select * From Customer");
			ResultSet rs = psGetBalance.executeQuery();

			while (rs.next()) {

				System.out.print("Name: " + rs.getString(2) + " ");
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
		employeeAccount.showEmployeeAccountMenu();
	}
}
