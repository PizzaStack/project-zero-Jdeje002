package com.employee;

import org.junit.Test;



public class EmployeeTest {

	
	@Test
	public void canInstansiate() {
		EmployeeStartUp employee = new EmployeeStartUp();
		employee.startUpEmployee();
		
		EmployeeMenu employeeMenu = new EmployeeMenu();
		EmployeeLogIn employeeSignIn = new EmployeelogIn();
	}
	
	
	
}
