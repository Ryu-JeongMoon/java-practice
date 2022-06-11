package org.eternity.movie.step01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eternity.money.Money;

public abstract class DiscountPolicy {

	private List<DiscountCondition> conditions = new ArrayList<>();

	public DiscountPolicy(DiscountCondition... conditions) {
		this.conditions = Arrays.asList(conditions);
	}

	public Money calculateDiscountAmount(Screening screening) {
		for (DiscountCondition each : conditions) {
			if (each.isSatisfiedBy(screening)) {
				return getDiscountAmount(screening);
			}
		}

		return Money.ZERO;
	}

	abstract protected Money getDiscountAmount(Screening Screening);
}

/*
overriding, overloading 혼동을 주의해야 한다
오버라이딩이란 부모 타입에서 정의된 메서드를 재정의한다는 것이고
오버로딩이란 같은 메서드 시그니처를 갖지만 받는 매개변수가 다른 것이다
주의해야할 점으로 같은 계층의 오버로딩이 아니어도 성립한다

DiscountPolicy의 calculateDiscountAmount(Screening screening)을 하위 타입에서
calculateDiscountAmount(other parameter)로 받아버리면 두 메서드는 공존한다
 */