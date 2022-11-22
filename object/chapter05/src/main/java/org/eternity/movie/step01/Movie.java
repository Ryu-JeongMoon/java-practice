package org.eternity.movie.step01;

import java.time.Duration;
import java.util.List;

import org.eternity.money.Money;

public class Movie {

	private String title;
	private Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Money calculateMovieFee(Screening screening) {
		if (isDiscountable(screening)) {
			return fee.minus(calculateDiscountAmount());
		}

		return fee;
	}

	private boolean isDiscountable(Screening screening) {
		return discountConditions.stream()
			.anyMatch(condition -> condition.isSatisfiedBy(screening));
	}

	private Money calculateDiscountAmount() {
		return switch (movieType) {
			case AMOUNT_DISCOUNT -> calculateAmountDiscountAmount();
			case PERCENT_DISCOUNT -> calculatePercentDiscountAmount();
			case NONE_DISCOUNT -> calculateNoneDiscountAmount();
		};

	}

	private Money calculateAmountDiscountAmount() {
		return discountAmount;
	}


	private Money calculatePercentDiscountAmount() {
		return fee.times(discountPercent);
	}

	private Money calculateNoneDiscountAmount() {
		return Money.ZERO;
	}
}

/*
calculateMovieFee() Screening -> Movie
Movie에 대한 어떤 정보도 넘기지 않으며 Screening 자체를 넘긴다
메세지를 이런 방식으로 작성해야 Public Interface에 구현이 숨어들지 않는다
응집도가 낮을 때 발생하는 현상
1. 인스턴스 필드와 메서드를 그룹 별로 사용하지 않는 경우가 있다 -> if-else 분기를 태우는 경우도 포함
2. 인스턴스를 생성할 때 초기화하지 않는 필드가 있다

위와 같은 상황은 문맥에 따라 사용하는 필드가 달라지는 것인데 이럴 땐 그 문맥에 맞게 클래스를 분리해야 한다
Amount와 Percent를 분리하고 하나의 타입 계층으로 묶는다, 다형성 활용하기 위함
 */