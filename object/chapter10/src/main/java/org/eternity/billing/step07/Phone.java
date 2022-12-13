package org.eternity.billing.step07;

import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

public abstract class Phone {

	private List<Call> calls = new ArrayList<>();

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			result = result.plus(calculateCallFee(call));
		}

		return result;
	}

	abstract protected Money calculateCallFee(Call call);
}
