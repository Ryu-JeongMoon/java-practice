package org.eternity.billing.step02;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;

@Getter
public class Phone {

	private final Money amount;
	private final Duration seconds;
	private final List<Call> calls = new ArrayList<>();
	private final double taxRate;

	public Phone(Money amount, Duration seconds, double taxRate) {
		this.amount = amount;
		this.seconds = seconds;
		this.taxRate = taxRate;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
		}

		return result.plus(result.times(taxRate));
	}
}
