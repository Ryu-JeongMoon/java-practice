package org.eternity.theater.step01;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		if (audience.bag().hasInvitation()) {
			Ticket ticket = ticketSeller.ticketOffice().getTicket();
			audience.bag().setTicket(ticket);
		} else {
			Ticket ticket = ticketSeller.ticketOffice().getTicket();
			audience.bag().minusAmount(ticket.fee());
			ticketSeller.ticketOffice().plusAmount(ticket.fee());
			audience.bag().setTicket(ticket);
		}
	}
}

