package org.designpattern.structure.adapter._02_after;

import org.designpattern.structure.adapter._02_after.security.UserDetails;

public record AccountUserDetails(Account account) implements UserDetails {

	@Override
	public String getUsername() {
		return account.name();
	}

	@Override
	public String getPassword() {
		return account.password();
	}
}
