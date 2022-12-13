package org.eternity.billing.step01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;

@Getter
public class Phone {

	private final Money amount;
	private final Duration seconds;
	private final List<Call> calls;

	public Phone(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
		this.calls = new ArrayList<>();
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}

		return result;
	}
}
