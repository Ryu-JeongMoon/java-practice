package org.designpattern.structure.adapter._02_after;

public class AccountService {

	public Account findAccountByUsername(String username) {
		return new Account(username, username, username);
	}

	public void createNewAccount(Account account) {

	}

	public void updateAccount(Account account) {

	}
}
