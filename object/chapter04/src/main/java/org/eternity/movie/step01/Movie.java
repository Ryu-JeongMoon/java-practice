package org.eternity.movie.step01;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.eternity.money.Money;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

	private final String title;
	private final Duration runningTime;
	private Money fee;
	private List<DiscountCondition> discountConditions;

	private MovieType movieType;
	private Money discountAmount;
	private double discountPercent;

	public Movie(String title, Duration runningTime, Money fee, double discountPercent, DiscountCondition... discountConditions) {
		this(MovieType.PERCENT_DISCOUNT, title, runningTime, fee, Money.ZERO, discountPercent, discountConditions);
	}

	public Movie(String title, Duration runningTime, Money fee, Money discountAmount, DiscountCondition... discountConditions) {
		this(MovieType.AMOUNT_DISCOUNT, title, runningTime, fee, discountAmount, 0, discountConditions);
	}

	public Movie(String title, Duration runningTime, Money fee) {
		this(MovieType.NONE_DISCOUNT, title, runningTime, fee, Money.ZERO, 0);
	}

	private Movie(
		MovieType movieType, String title, Duration runningTime, Money fee,
		Money discountAmount, double discountPercent, DiscountCondition... discountConditions
	) {
		this.movieType = movieType;
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountAmount = discountAmount;
		this.discountPercent = discountPercent;
		this.discountConditions = Arrays.asList(discountConditions);
	}
}

/*
객체를 데이터 중심으로 바라보면 객체지향에서 의미하는 자율적인 객체의 역할을 수행할 수 없다
데이터 덩어리일 뿐이고 절차지향적인 코드를 짜 외부에서 덩어리를 요리조리 다듬어 기능을 만든다
객체를 자료구조처럼 다루기 때문에 캡슐화가 지켜질 수 없고, 이는 변경의 파급 효과가 널리 퍼지는 것을 의미한다
 */