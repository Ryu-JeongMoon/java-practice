package org.eternity.movie.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.eternity.money.Money;
import org.eternity.movie.step01.pricing.PercentDiscountPolicy;
import org.eternity.movie.step01.pricing.PeriodCondition;

public class Main {

	public static void main(String[] args) {
		Screening screening = new Screening(
			new Movie("call me by your name", Duration.ofHours(2), Money.wons(12000),
				new PercentDiscountPolicy(
					0.8,
					new PeriodCondition(
						DayOfWeek.WEDNESDAY,
						LocalTime.of(16, 0),
						LocalTime.of(20, 0))
				)
			),
			3,
			LocalDateTime.of(2022, 7, 16, 0, 0, 0)
		);

		Reservation reservation = screening.reserve(
			new Customer("panda", "bear"),
			3
		);

		System.out.println("reservation = " + reservation);
	}
}

/*
진정한 객체지향에 다가서려면 클래스 중심이 아닌 객체 중심으로 봐야 한다
특정 역할을 수행하는 것이 객체고 이를 일반화한 것이 클래스이기 때문이다
객체 간 메세지를 전송하여 의사소통하고 하나의 기능을 구현하게 된다
어떠한 State, Behavior 필요한지 정해서 객체를 명확히 정의하고 이를 일반화해 틀 형태의 클래스를 작성한다
유연한 설계를 위해서는 구체 클래스에 의존하지 않도록 하고 추상화에 의존하도록 한다

객체지향의 강점 중 하나는 설계부터 구현까지 일관되게 객체라는 추상화를 사용할 수 있다는 것이다
일반적으로 특정 분야의 문제 해결을 위해 프로그램을 사용할 때 그 분야를 도메인이라 한다
 */