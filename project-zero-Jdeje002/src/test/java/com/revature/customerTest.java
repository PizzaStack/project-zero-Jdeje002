package com.revature;

import org.junit.Test;

public class customerTest {
	double balance;
	@Test
	public void canInstansiate() {
		Account account = new Account();
		Login logIn = new Login();
		Register register= new Register();
		StartUp startUp = new StartUp();
	}
	
	@Test
	public void Deposit(double amount) {
		balance = balance + amount;
	}
	@Test
	public void withdraw(double amount) {
		balance = balance - amount;
		
	}
	@Test
	public void showBalance() {
		System.out.println("Your Balance is : " + balance);
	}
}
