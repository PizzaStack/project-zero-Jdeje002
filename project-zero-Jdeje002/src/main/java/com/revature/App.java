package com.revature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello! Please enter Number option \n 1.login Unique Id \n 2.Sign up account"  );
        Customers customer = new Customers();
        customer.setUpAccount();
    }        
}
