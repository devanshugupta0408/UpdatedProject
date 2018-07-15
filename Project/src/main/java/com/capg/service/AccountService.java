package com.capg.service;

import com.capg.bea.AccountDetails;
import com.capg.dao.AccountDAO;

public class AccountService implements IAccountService {
	AccountDAO dao = new AccountDAO();

	public boolean createAccount(AccountDetails account) {
		return dao.createAccount(account);
	}

	public boolean depositBalance(int deposit, AccountDetails account) {
		return dao.depositBalance(deposit, account);
	}

	public void showBalance(AccountDetails account) {

		dao.showBalance(account);

	}

	public boolean withdrawBalance(int withdraw, AccountDetails account) {
		return dao.withdrawBalance(withdraw, account);
	}

	public boolean FundTransfer(long accountNumber, AccountDetails account) {
		return dao.FundTransfer(accountNumber, account);
	}

	public void PrintTransaction(AccountDetails account) {
		// TODO Auto-generated method stub
		dao.PrintTransaction(account);
	}
}
