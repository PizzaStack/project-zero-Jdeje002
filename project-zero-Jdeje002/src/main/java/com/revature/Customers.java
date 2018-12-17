package com.revature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Customers {
	private int uniqueId;
	private String name;
	private double balance;
	private String accountStatus;

	private String Customer = "C:\\Users\\jdeje\\Desktop\\project-zero-Jdeje002\\project-zero-Jdeje002\\PsudoDb\\PsudoTable\\Customer";

	private File uniqueIdFile = new File(Customer + "UniqueId.txt");
	private File nameFile = new File(Customer + "Name.txt");
	private File balanceFile = new File(Customer + "Balance.txt");
	private File accountStatusFile = new File(Customer + "AccountStatus.txt");
	

	//Method to obtain data from user to create new user
	public void obtainDataFromUserForNewCustomer() {
		
		Scanner scaner = new Scanner(System.in);
		System.out.println("Enter in the Customer name:");
		name = scaner.nextLine();
		System.out.println(name);
		commitCustomerName();
		
	}
	// stores in psudoDb for customer name 
	public void commitCustomerName() {
		try (	
				// Name prints to name.txt
				FileOutputStream nameFos = new FileOutputStream(nameFile, true);
				PrintStream namePs = new PrintStream(nameFos);
		) {
			namePs.println(name);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
	}		       
		    
	
	// this  method section gets data from user to put into  PsudoDb
	
	public void setUpAccount() {
		// checking is there is a file
		boolean exist = uniqueIdFile.exists();
		
		if(!exist) {
		
		try (
				// Unique Id print to UniqueId.txt
				FileOutputStream uniqueIdFos = new FileOutputStream(uniqueIdFile, true);
				PrintStream uniqueIdPs = new PrintStream(uniqueIdFos);

				// Name prints to name.txt
				FileOutputStream nameFos = new FileOutputStream(nameFile, true);
				PrintStream namePs = new PrintStream(nameFos);
				// Balance Prints to Balance.text
				FileOutputStream balanceFos = new FileOutputStream(balanceFile, true);
				PrintStream balancePs = new PrintStream(balanceFos, true);
				// AccountStatus Prints to AccountStatus.txt
				FileOutputStream accountStatusFos = new FileOutputStream(accountStatusFile, true);
				PrintStream accountStatusPs = new PrintStream(accountStatusFos, true);

		) {
			uniqueIdPs.println(0);
			namePs.println(0);
			balancePs.println(0);
			accountStatusPs.println(0);

		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
		}
	}
	
}
