package org.eternity.billing.step03;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;

@Getter
public class Phone {

	private static final int LATE_NIGHT_HOUR = 22;
	private final PhoneType type;
	private final Money amount;
	private final Money regularAmount;
	private final Money nightlyAmount;
	private final Duration seconds;
	private final List<Call> calls = new ArrayList<>();

	public Phone(Money amount, Duration seconds) {
		this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
	}

	public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
		this(PhoneType.NIGHTLY, Money.ZERO, nightlyAmount, regularAmount, seconds);
	}

	public Phone(PhoneType type, Money amount, Money nightlyAmount, Money regularAmount, Duration seconds) {
		this.type = type;
		this.amount = amount;
		this.regularAmount = regularAmount;
		this.nightlyAmount = nightlyAmount;
		this.seconds = seconds;
	}

	public Money calculateFee() {
		Money result = Money.ZERO;

		for (Call call : calls) {
			if (type == PhoneType.REGULAR) {
				result = result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
			} else {
				if (call.from().getHour() >= LATE_NIGHT_HOUR) {
					result = result.plus(nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
				} else {
					result = result.plus(regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
				}
			}
		}

		return result;
	}

	enum PhoneType { REGULAR, NIGHTLY }
}
