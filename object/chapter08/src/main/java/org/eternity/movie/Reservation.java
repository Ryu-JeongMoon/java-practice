package org.eternity.movie;

import org.eternity.money.Money;

public class Reservation {

	private final Customer customer;
	private final Screening Screening;
	private final Money fee;
	private final int audienceCount;

	public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount) {
		this.customer = customer;
		this.Screening = Screening;
		this.fee = fee;
		this.audienceCount = audienceCount;
	}
}
