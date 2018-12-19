package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Register {
	
	private String userName;
	private String password;
	private int uniqueId;
	private String Customer = "C:\\Users\\jdeje\\Desktop\\project-zero-Jdeje002\\project-zero-Jdeje002\\PsudoDb\\PsudoTable\\Customer";

	private File passwordFile = new File(Customer + "CustomerPassword.txt");
	private File nameFile = new File(Customer + "Name.txt");
	private File uniqueIdFile = new File(Customer + "UniqueId.txt");
	
	
	public void signUp() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("========================================");
		 System.out.println("Enter you name");
		 System.out.println("========================================");
		 
		 this.userName = scanner.nextLine();
		
		 
		 
		 System.out.println("========================================");
		 System.out.println("Enter you a Password");
		 System.out.println("========================================");
		
		 this.password = scanner.nextLine();
		 
		 
		 try {
	         Class.forName("org.postgresql.Driver");
	     }
	     catch (java.lang.ClassNotFoundException e) {
	         System.out.println(e.getMessage());
	     }

	     String url = "jdbc:postgresql://baasu.db.elephantsql.com:5432/nxdkszrk";
	     String username = "nxdkszrk";
	     String dbpassword = "gLuT7i1-smGK4dqU-yUcwdZXeHxgarKC";

	     try {
	         Connection db = DriverManager.getConnection(url, username, dbpassword);
	         Statement st = db.createStatement();
	         st.executeQuery("INSERT INTO customer (name,password, balance, approved) values ('"+userName+"','"+password+"',0,False)");
	         
	         //rs.close();
	         st.close();
	         // needed
	         db.close();
	         }
	     catch (java.sql.SQLException e) {
	         //System.out.println(e.getMessage());
	     }
		 
	
	
	}
}
