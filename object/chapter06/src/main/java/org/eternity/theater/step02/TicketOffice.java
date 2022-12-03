package org.eternity.theater.step02;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

	private final List<Ticket> tickets = new ArrayList<>();
	private Long amount;

	public TicketOffice(Long amount, Ticket... tickets) {
		this.amount = amount;
		this.tickets.addAll(List.of(tickets));
	}

	public Ticket getTicket() {
		return tickets.remove(0);
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long sell) {
		this.amount += sell;
	}
}
