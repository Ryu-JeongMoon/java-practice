package org.eternity.movie.step03;

import java.time.LocalDateTime;

import org.eternity.money.Money;

public record Screening(Movie movie, int sequence, LocalDateTime whenScreened) {

	public LocalDateTime getStartTime() {
		return whenScreened;
	}

	public boolean isSequence(int sequence) {
		return this.sequence == sequence;
	}

	public Money getMovieFee() {
		return movie.fee();
	}

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}
}
