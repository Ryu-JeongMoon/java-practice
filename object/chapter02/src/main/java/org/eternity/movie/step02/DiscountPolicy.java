package org.eternity.movie.step02;

import org.eternity.money.Money;

public interface DiscountPolicy {

	Money calculateDiscountAmount(Screening screening);
}
