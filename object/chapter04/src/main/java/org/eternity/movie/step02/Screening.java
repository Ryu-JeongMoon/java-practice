package org.eternity.movie.step02;

import java.time.LocalDateTime;

import org.eternity.money.Money;

public class Screening {

	private final Movie movie;
	private final int sequence;
	private final LocalDateTime whenScreened;

	public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
		this.movie = movie;
		this.sequence = sequence;
		this.whenScreened = whenScreened;
	}

	public Money calculateFee(int audienceCount) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculateAmountDiscountedFee().times(audienceCount);
				}
				break;
			case PERCENT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculatePercentDiscountedFee().times(audienceCount);
				}
			case NONE_DISCOUNT:
				movie.calculateNoneDiscountedFee().times(audienceCount);
		}

		return movie.calculateNoneDiscountedFee().times(audienceCount);
	}
}
