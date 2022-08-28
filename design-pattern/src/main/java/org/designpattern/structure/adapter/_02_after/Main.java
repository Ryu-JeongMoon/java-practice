package org.designpattern.structure.adapter._02_after;

import org.designpattern.structure.adapter._02_after.security.LoginHandler;

public class Main {

	public static void main(String[] args) {
		AccountService accountService = new AccountService();
		AccountUserDetailsService accountUserDetailsService = new AccountUserDetailsService(accountService);
		LoginHandler loginHandler = new LoginHandler(accountUserDetailsService);
		String login = loginHandler.login("panda", "panda");
		System.out.println("login = " + login);
	}
}
