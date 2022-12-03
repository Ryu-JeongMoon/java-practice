package org.eternity.theater.step03;

public record Audience(Bag bag) {

	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
}

