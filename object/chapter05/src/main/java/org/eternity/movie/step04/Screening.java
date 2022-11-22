package org.eternity.movie.step04;

import java.time.LocalDateTime;

import org.eternity.money.Money;

public record Screening(Movie movie, int sequence, LocalDateTime whenScreened) {

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}
}
