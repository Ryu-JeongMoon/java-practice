package org.designpattern.structure.adapter._02_after;

import org.designpattern.structure.adapter._02_after.security.UserDetails;
import org.designpattern.structure.adapter._02_after.security.UserDetailsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccountUserDetailsService implements UserDetailsService {

	private final AccountService accountService;

	@Override
	public UserDetails loadUser(String username) {
		Account account = accountService.findAccountByUsername(username);
		return new AccountUserDetails(account);
	}
}
