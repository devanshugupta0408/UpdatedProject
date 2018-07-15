package com.capg.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capg.bea.AccountDetails;

public class AccountDAOTest {

	AccountDAO dao = new AccountDAO();
	AccountDetails ad = new AccountDetails();

	@Test
	public void testCreateAccount() {
		assertEquals(true, dao.createAccount(ad));
	}

	@Test
	public void testDepositBalance() {
		assertEquals(true, dao.depositBalance(1000, ad));
	}

	@Test
	public void testShowBalance() {
		assertNotNull(dao);
	}

	@Test
	public void testWithdrawBalance() {
		assertEquals(true, dao.withdrawBalance(1000, ad));
	}

	@Test
	public void testFundTransfer() {
		assertEquals(true, dao.FundTransfer(1122334, ad));
	}

	@Test
	public void testPrintTransaction() {
		assertNotNull(dao);
	}

}
