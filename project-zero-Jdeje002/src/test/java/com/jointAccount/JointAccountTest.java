package com.jointAccount;

import org.junit.Test;

public class JointAccountTest {
	@Test
	public  void caninstansiate() {
		JointLogIn jl = new JointLogIn();
		JointRegister jr = new JointRegister();
		JointAccount jA = new JointAccount();
		JointCheckBalance jcb = new JointCheckBalance();
		JointDeposit jointDeposit = new JointDeposit();
	}

	
}
