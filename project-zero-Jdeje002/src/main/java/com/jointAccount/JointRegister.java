package com.jointAccount;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.App;

public class JointRegister {
	// db account info
	protected String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	protected String dbUserName = "nxdkszrk";
	protected String dbPassword = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

	// users
	protected String mainAccountHolder;
	protected String mainAccountHolderId;
	protected String secondaryAccountHolder;
	protected String secondaryAccountHolderId;
	protected String accountPassword;
	protected Double jointBalance;
	protected Double mainAccountBalance;
	protected Double secondaryAccountBalance;
	protected int jointAccountId;
	protected String approvalMain;
	protected String approvalSecondary;

	static final Logger log = Logger.getLogger(App.class);

	public void startUp() {
		// scanner
		Scanner scanner = new Scanner(System.in);

		System.out.println("===============================================");
		System.out.println("To regisiser for a joint account");
		System.out.println("Enter in the Account Id for Main Account.");
		System.out.println("===============================================");
		System.out.println("\n");

		this.mainAccountHolderId = scanner.nextLine();
		setMainAccountHolderName();

		System.out.println("===============================================");

		System.out.println("Enter in the Account Id for Secandary Account.");
		System.out.println("===============================================");
		System.out.println("\n");

		this.secondaryAccountHolderId = scanner.nextLine();
		SetSecondaryAccountHolder();

		System.out.println("===============================================");
		System.out.println("Enter A Password For the Account.");
		System.out.println("===============================================");
		System.out.println("\n");

		this.accountPassword = scanner.nextLine();

		getApprovalMain();
		getApprovalSecondary();

		if (approvalMain.equals("Pending") || approvalSecondary.equals("Pending")) {
			System.out.println("========================================");
			System.out.println("Accounts has not been approved");
			System.out.println("========================================");
		} else if (approvalMain.equals("Deny") || approvalSecondary.equals("Deny")) {
			System.out.println("========================================");
			System.out.println("Account has not been denied");
			System.out.println("========================================");
		} else {
			// users new balance
			SetJointaccountBalance();
			// db insert new user into table
			setUpJointAccountTable();
			// get joint account account Id

			getJointAccountId();

			System.out.println("===============================================");
			System.out.println("Your Account Id is: " + jointAccountId);
			System.out.println("===============================================");
			System.out.println("\n");
		}

	}

	public void getApprovalMain() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT approved from customer Where customer_id = '" + this.mainAccountHolderId + "';");
			while (rs.next()) {
				approvalMain = rs.getString(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getApprovalSecondary() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT approved from customer Where customer_id = '" + this.secondaryAccountHolderId + "';");
			while (rs.next()) {
				approvalSecondary = rs.getString(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setMainAccountHolderName() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st
					.executeQuery("SELECT name1 FROM customer Where customer_id = '" + this.mainAccountHolderId + "';");

			while (rs.next()) {
				mainAccountHolder = rs.getString(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void SetSecondaryAccountHolder() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT name1 FROM customer Where customer_id = '" + this.secondaryAccountHolderId + "';");

			while (rs.next()) {
				secondaryAccountHolder = rs.getString(1);

			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getMainBalance() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT balance FROM customer Where customer_id = '" + this.mainAccountHolderId + "';");

			while (rs.next()) {
				mainAccountBalance = rs.getDouble(1);
			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void getSecondaryBalance() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT balance FROM customer Where customer_id = '" + this.secondaryAccountHolderId + "';");

			while (rs.next()) {
				secondaryAccountBalance = rs.getDouble(1);

			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void SetJointaccountBalance() {
		getMainBalance();
		getSecondaryBalance();
		jointBalance = secondaryAccountBalance + mainAccountBalance;

	}

	public void getJointAccountId() {

		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT customer_id FROM jointaccount Where mainaccountholder = '" + this.mainAccountHolder + "';");

			while (rs.next()) {
				jointAccountId = rs.getInt(1);

			}
			rs.close();
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void setUpJointAccountTable() {
		try {
			Connection db = DriverManager.getConnection(url, dbUserName, dbPassword);
			Statement st = db.createStatement();
			st.executeUpdate(
					"INSERT INTO jointaccount (mainAccountHolder,secondaryAccountHolder,password,balance,accountApproved) values('"
							+ this.mainAccountHolder + "','" + this.secondaryAccountHolder + "','"
							+ this.accountPassword + "','" + jointBalance + "','Pending')");
			
			log.info("New Joint Acocunt made with: " + mainAccountHolder + " " + secondaryAccountHolder
					+ " with a balance of " + jointBalance + " and a password of : " + accountPassword);
			
			st.close();
			// needed
			db.close();
		} catch (java.sql.SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
