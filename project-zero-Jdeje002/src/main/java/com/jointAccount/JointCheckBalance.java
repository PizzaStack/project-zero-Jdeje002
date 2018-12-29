package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.revature.App;

public class JointCheckBalance extends JointRegister {

	private double jointBalance;
	static final Logger log = Logger.getLogger(App.class);

	public void getBalance(int jointAccountId) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT balance FROM jointaccount Where customer_id = '" + jointAccountId + "';");
			log.info("User :"+jointAccountId+ " viewed balance");
			while (rs.next()) {
				jointBalance = rs.getInt(1);
				System.out.println(jointBalance);
				System.out.println("========================================");
				System.out.println("Your Balance is : " + jointBalance);
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
