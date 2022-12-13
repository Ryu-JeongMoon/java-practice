package org.eternity.billing.step08;

import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

public abstract class Phone {

	private final double taxRate;
	private final List<Call> calls = new ArrayList<>();

	public Phone(double taxRate) {
		this.taxRate = taxRate;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}

		return result.plus(result.times(taxRate));
	}

	protected abstract Money calculateCallFee(Call call);
}
