package com.revature;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
     
//        Customers customer = new Customers();
        
       
        BankAccount bankAccount = new BankAccount("test","123");
        bankAccount.showMenu();
        
//        customer.setUpAccount();
//        customer.obtainDataFromUserForNewCustomer();
    }        
}
