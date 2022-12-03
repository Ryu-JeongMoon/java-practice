package org.eternity.theater.step03;

public class Bag {

	private final Invitation invitation;
	private Long amount;
	private Ticket ticket;

	public Bag(long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, long amount) {
		this.invitation = invitation;
		this.amount = amount;
	}

	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			this.ticket = ticket;
			return 0L;
		} else {
			this.ticket = ticket;
			minusAmount(ticket.fee());
			return ticket.fee();
		}
	}

	private boolean hasInvitation() {
		return invitation != null;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}
}
