package org.eternity.theater.step03;

public record TicketSeller(TicketOffice ticketOffice) {

	public void sellTo(Audience audience) {
		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
	}
}
