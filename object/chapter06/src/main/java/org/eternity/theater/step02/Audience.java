package org.eternity.theater.step02;

public record Audience(Bag bag) {

	public Long setTicket(Ticket ticket) {
		return bag.setTicket(ticket);
	}
}

