package org.eternity.billing.step06;

import java.time.Duration;

import org.eternity.money.Money;

public class Phone extends AbstractPhone {

	private final Money amount;
	private final Duration seconds;

	public Phone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
