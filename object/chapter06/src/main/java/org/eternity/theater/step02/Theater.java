package org.eternity.theater.step02;

public record Theater(TicketSeller ticketSeller) {

	public void enter(Audience audience) {
		ticketSeller.setTicket(audience);
	}
}

