package com.revature;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
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
		 
		 try (

					// Name prints to name.txt
					FileOutputStream nameFos = new FileOutputStream(nameFile, true);
					PrintStream namePs = new PrintStream(nameFos);	
				 	// Password Print to name.txt
				 	FileOutputStream passwordFos = new FileOutputStream(passwordFile, true);
					PrintStream passwordPs = new PrintStream(passwordFos);
				    // unique Id into new
				 	FileOutputStream uniqueIdFos = new FileOutputStream(uniqueIdFile, true);
					PrintStream uniqueIdPs = new PrintStream(uniqueIdFos);
			) {
				
				namePs.println(this.userName);
				passwordPs.println(this.password);
				passwordPs.println(0);
				
				

			} catch (FileNotFoundException e) {

			} catch (IOException e) {
			}
		 
		
	}
	
	
	
}
