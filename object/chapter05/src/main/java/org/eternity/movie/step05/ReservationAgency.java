package org.eternity.movie.step05;

import org.eternity.money.Money;

// todo, 메서드 옮겨보기
public class ReservationAgency {

	public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
		boolean discountable = checkDiscountable(screening);
		Money fee = calculateFee(screening, discountable, audienceCount);
		return createReservation(screening, customer, audienceCount, fee);
	}

	private boolean checkDiscountable(Screening screening) {
		return screening.movie().getDiscountConditions().stream()
			.anyMatch(condition -> condition.isDiscountable(screening));
	}

	private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
		if (discountable) {
			return screening.movie().getFee()
				.minus(calculateDiscountedFee(screening.movie()))
				.times(audienceCount);
		}

		return screening.movie().getFee();
	}

	private Money calculateDiscountedFee(Movie movie) {
		return switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT -> calculateAmountDiscountedFee(movie);
			case PERCENT_DISCOUNT -> calculatePercentDiscountedFee(movie);
			case NONE_DISCOUNT -> calculateNoneDiscountedFee(movie);
		};

	}

	private Money calculateAmountDiscountedFee(Movie movie) {
		return movie.getDiscountAmount();
	}

	private Money calculatePercentDiscountedFee(Movie movie) {
		return movie.getFee().times(movie.getDiscountPercent());
	}

	private Money calculateNoneDiscountedFee(Movie movie) {
		return movie.getFee();
	}

	private Reservation createReservation(Screening screening,
		Customer customer, int audienceCount, Money fee) {
		return new Reservation(customer, screening, fee, audienceCount);
	}
}
