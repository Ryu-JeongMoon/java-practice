package org.eternity.theater.step03;

public record Theater(TicketSeller ticketSeller) {

	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}

