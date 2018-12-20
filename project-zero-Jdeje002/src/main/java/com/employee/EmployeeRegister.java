package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.revature.Register;

public class EmployeeRegister extends Register {
	
	
	public void employeeRegister() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("===============================================================");
			System.out.println("To signup Please enter your name and a password for the account");
			System.out.println("===============================================================");
			System.out.println("\n");

			System.out.println("===============================================================");
			System.out.println("Enter you name.");
			System.out.println("===============================================================");

			super.userName = scanner.nextLine();

			System.out.println("===============================================================");
			System.out.println("Enter you a password.");
			System.out.println("===============================================================");

			super.password = scanner.nextLine();
			System.out.println("\n");
			
			setEmployeeDB();
		
		
	}

	private void setEmployeeDB() {
		
		try {
			Connection db = DriverManager.getConnection(super.url, super.username, super.dbpassword);
			Statement st = db.createStatement();
			st.executeQuery("INSERT INTO employee (name1,password) values ('" + super.userName + "','"
					+ super.password +"');");

			// rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			// System.out.println(e.getMessage());
		}
		
	}

}
