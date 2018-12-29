package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.App;

public class JointWithdraw extends JointRegister{
	
	protected double oldBalance;
	protected double newBalance;
	protected double userWithdrawal;
	
	Scanner scanner = new Scanner(System.in);
	static final Logger log = Logger.getLogger(App.class);
	
	public void withdrawFromJointAccount(int jointAccountId) {
		
		System.out.println("===============================");
		System.out.println("Enter Withdrawal amount: ");
		System.out.println("===============================");
		System.out.println("\n");
	
		this.userWithdrawal = scanner.nextDouble();
		connectDb(jointAccountId);
		newBalance = oldBalance - userWithdrawal;
		if(newBalance <= 0) {
			System.out.println("\n");
			System.out.println("========================================");
			System.out.println("insufficient funds");
			System.out.println("========================================");
		}else {
			setNewBalance(jointAccountId,newBalance);
			
			System.out.println("\n");
			System.out.println("========================================");
			System.out.println("Balance is now :" + newBalance);
			System.out.println("========================================");
			log.info("user id :" +jointAccountId+ " has Withdrawed: " + userWithdrawal+ " with a new blance of: "+newBalance);
		}
		
	}
	
	
	public void connectDb(int jointAccountId) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT balance FROM jointaccount Where customer_id = '" + jointAccountId + "';");

			while (rs.next()) {

				oldBalance = rs.getDouble(1);

			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	public void setNewBalance(double jointAccountId, double newBalance) {
		try {
			Connection db = DriverManager.getConnection(super.url, super.dbUserName, super.dbPassword);
			Statement st = db.createStatement();
			st.executeUpdate("Update jointaccount Set balance ="+newBalance+" where customer_id =" + jointAccountId+";");

			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
