package com.revature;

import java.util.Scanner;

public class StartUp {
	public void startUp() {
		 Scanner scanner = new Scanner(System.in);
	    	
    	 System.out.println("=======================================" );
    	 System.out.println("Welcome "  );
		
    	 
		 System.out.println("\n");
		 
		 System.out.println("=======================================" );
		 System.out.println("1. Sign in" );
		 System.out.println("2. Register new Account");
		 
		 System.out.println("3. Exit App");
		 System.out.println("=======================================" );
		 
		 int option = 0;
		 
		 option = scanner.nextInt();
		 
		 switch (option) {
		 // Sign in 
		 case 1:
			 Login L = new Login();
			 L.logIn();
			 break;
		 // register
		 case 2:
			 Register register = new Register();
			 register.signUp();
			 Login L1 = new Login();
			 L1.logIn();
			 break;
		 case 3 :
			 System.out.println("Thank you , Good-bye");
			 break;
		 default: 
			 System.out.println("Sorry was not an option.");
			 break;
		 }
	}
}
