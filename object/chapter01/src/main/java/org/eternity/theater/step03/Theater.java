package org.eternity.theater.step03;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}

/*
객체지향에서의 객체는 살아 움직이는 무언가다
현실세계와의 100% 일치가 아니며 자율적인 생물이다
객체 간에 message로 의사소통을 하고 특정 문맥 하에서 적절한 책임을 수행해 프로그램이 완성된다
 */