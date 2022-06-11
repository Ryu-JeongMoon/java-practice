package org.eternity.money;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	public static final Money ZERO = Money.wons(0);

	private final BigDecimal amount;

	public static Money wons(long amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	public static Money wons(double amount) {
		return new Money(BigDecimal.valueOf(amount));
	}

	Money(BigDecimal amount) {
		this.amount = amount;
	}

	public Money plus(Money amount) {
		return new Money(this.amount.add(amount.amount));
	}

	public Money minus(Money amount) {
		return new Money(this.amount.subtract(amount.amount));
	}

	public Money times(double percent) {
		return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
	}

	public boolean isLessThan(Money other) {
		return amount.compareTo(other.amount) < 0;
	}

	public boolean isGreaterThanOrEqual(Money other) {
		return amount.compareTo(other.amount) >= 0;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Money)) {
			return false;
		}

		Money other = (Money)object;
		return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
	}

	public int hashCode() {
		return Objects.hashCode(amount);
	}

	public String toString() {
		return amount.toString() + "원";
	}
}

/*
instance field를 하나만 갖더라도 의미를 명확하게 전달할 수 있으면 객체를 생성하는 것이 좋다
반복적인 로직 작성을 줄여줄 수 있고, 숫자 타입이 아닌 금액을 나타내는 것을 명시할 수 있다
 */