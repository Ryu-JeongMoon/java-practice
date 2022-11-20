package org.eternity.movie.step01;

import org.eternity.money.Money;

public class ReservationAgency {

	public Reservation reserve(Screening screening, Customer customer,
		int audienceCount) {
		Movie movie = screening.getMovie();

		boolean discountable = false;
		for (DiscountCondition condition : movie.getDiscountConditions()) {
			if (condition.getType() == DiscountConditionType.PERIOD) {
				discountable = screening.getWhenScreened().getDayOfWeek().equals(condition.getDayOfWeek()) &&
					!condition.getStartTime().isAfter(screening.getWhenScreened().toLocalTime()) &&
					!condition.getEndTime().isBefore(screening.getWhenScreened().toLocalTime());
			} else {
				discountable = condition.getSequence() == screening.getSequence();
			}

			if (discountable) {
				break;
			}
		}

		Money fee;
		if (discountable) {
			Money discountAmount = switch (movie.getMovieType()) {
				case AMOUNT_DISCOUNT -> movie.getDiscountAmount();
				case PERCENT_DISCOUNT -> movie.getFee().times(movie.getDiscountPercent());
				case NONE_DISCOUNT -> Money.ZERO;
			};

			fee = movie.getFee().minus(discountAmount).times(audienceCount);
		} else {
			fee = movie.getFee().times(audienceCount);
		}

		return new Reservation(customer, screening, fee, audienceCount);
	}
}
