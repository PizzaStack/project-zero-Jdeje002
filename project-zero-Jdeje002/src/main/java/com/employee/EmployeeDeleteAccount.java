package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.Account;
import com.revature.App;

public class EmployeeDeleteAccount extends Account {
	private int Id;
	static final Logger log = Logger.getLogger(App.class);
	
	public void deleteCustomerAccount() {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========================================");
		System.out.println("Enter Cutomer Id To Delete Account");
		System.out.println("========================================");
		
		Id = scanner.nextInt();
		
		getId();
		deleteAccount();
		
		log.info("User Id: "+Id+" has been deleted.");
		System.out.println("========================================");
		System.out.println("Account Deleted, Returning to menu.");
		System.out.println("========================================");
		
	
		

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

	public void deleteAccount() {
		try {
			Connection db = DriverManager.getConnection(super.url, super.username, super.password);
			Statement st = db.createStatement();
			st.executeUpdate("DELETE FROM customer Where customer_id ="+ Id+";");
			
			st.close();
			
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
	}


}
