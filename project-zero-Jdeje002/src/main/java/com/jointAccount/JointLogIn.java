package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JointLogIn extends JointRegister {

		public void jointLogIn() {
			Scanner scanner = new Scanner(System.in);

			System.out.println("========================================");
			System.out.println("To Log in Enter your name and password");
			System.out.println("========================================");
			
			System.out.println("========================================");
			System.out.println("Please enter your Account Id");
			System.out.println("========================================");

			super.jointAccountId = scanner.nextInt();

			System.out.println("========================================");
			System.out.println("Please enter your Password");
			System.out.println("========================================");

			this.accountPassword = scanner.nextLine();
			
			
		}
		
		public void checkJointaccount() {
			try {
				Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
				Statement st = db.createStatement();
				ResultSet rs = st
						.executeQuery("");

				while (rs.next()) {
					
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
