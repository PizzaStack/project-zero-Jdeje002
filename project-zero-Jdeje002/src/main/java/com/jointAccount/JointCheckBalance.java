package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JointCheckBalance extends JointRegister{

	private double jointBalance;
	
	
	
	public void getBalance(int jointAccountId) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT balance FROM jointaccount Where customer_id = '" + jointAccountId + "';");

			while (rs.next()) {
				jointBalance = rs.getInt(1);
				System.out.println(jointBalance);
				System.out.println("========================================");
				System.out.println("Your Balance is : "+ jointBalance);
				System.out.println("========================================");
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
