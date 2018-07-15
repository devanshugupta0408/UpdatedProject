package com.capg.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capg.bea.AccountDetails;

public class AccountDAO {
	boolean flag = false;
	Scanner sc = new Scanner(System.in);
	public static List<AccountDetails> list = new ArrayList<AccountDetails>();

	public boolean createAccount(AccountDetails account)

	{
		flag = list.add(account);

		return flag;
	}

	public boolean depositBalance(int deposit, AccountDetails account) {
		int bal = account.getBalance();
		account.setBalance(bal + deposit);

		LocalDateTime d = LocalDateTime.now();

		String s = "Deposited Rs:" + deposit + " on " + d;
		account.getTrans().add(s);
		return true;
	}

	public void showBalance(AccountDetails account) {

		System.out.println(account.getBalance());

	}

	public boolean withdrawBalance(int withdraw, AccountDetails account) {

		int bal = account.getBalance();
		if (bal < 500)

			System.out.println("Account balance cannot be less tha 500");

		else {
			int withdrawn = bal - withdraw;
			if (withdrawn >= 500) {
				account.setBalance(withdrawn);
				LocalDateTime d = LocalDateTime.now();
				String s = "Withdrawn Rs:" + withdraw + " on " + d;
				account.getTrans().add(s);
				return true;
			} else
				account.setBalance(bal);
		}
		return false;
	}

	public boolean FundTransfer(long accountNumber, AccountDetails account) {

		System.out.println("Enter amount you want to transfer");
		int transferAmount = sc.nextInt();

		int userBalance = account.getBalance();
		for (AccountDetails fund : list) {
			if (fund.getAccountNumber() == accountNumber) {
				if (userBalance >= transferAmount) {
					fund.setBalance(fund.getBalance() + transferAmount);//
					account.setBalance(userBalance - transferAmount);
					int remainder = account.getBalance();
					if (remainder < 500) {
						System.out.println("Minimum bal. in the account should be 500");

						fund.setBalance(fund.getBalance() - transferAmount);
						System.out.println(fund.getBalance());
						account.setBalance(userBalance);
						System.out.println(account.getBalance());
						continue;
					}

					LocalDateTime d = LocalDateTime.now();
					String s = "Transfered Rs:" + transferAmount + " on " + d + " to " + accountNumber;
					account.getTrans().add(s);

					String s1 = "Received Rs:" + transferAmount + " on " + d + " from " + account.getAccountNumber();
					fund.getTrans().add(s1);
					return true;
				} else
					System.out.println("insufficient funds\n");

			}
		}

		return false;
	}

	/*
	 * public static List<AccountDetails> List() { return list; }
	 */
	public void PrintTransaction(AccountDetails account) {

		System.out.println(account.getTrans());

	}
}
