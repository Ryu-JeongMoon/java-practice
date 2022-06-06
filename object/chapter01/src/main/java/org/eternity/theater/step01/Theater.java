package org.eternity.theater.step01;

public class Theater {

	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) {
		if (audience.getBag().hasInvitation()) {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().setTicket(ticket);
		} else {
			Ticket ticket = ticketSeller.getTicketOffice().getTicket();
			audience.getBag().minusAmount(ticket.getFee());
			ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
			audience.getBag().setTicket(ticket);
		}
	}
}

/*
모든 소프트웨어 모듈은 세가지 목적이 있다
1. 정상 기능
2. 변경 가능
3. 이해 용이성

가장 중요한 것은 어찌 됐든 정상적인 작동이다
두번째는 소프트웨어 생애 주기 동안 계속해서 발생하는 변경에 유연하게 대응할 수 있어야 한다는 점이다
절차지향적인 구성으로 가져가면 하나의 작은 기능을 추가하더라도 큰 모듈을 건드려야 하고
조금 더 큰 규모로 보자면 얽혀있는 모듈 전체를 컴파일 해야 하고 MSA 구조에서도 마찬가지다
마지막으로는 컴퓨터가 알아보기 쉬운 구조가 아닌 사람이 알아보기 쉬운 구조로 작성해야 한다는 점이다

현재의 Theater는
1. 관람객이 가방을 가지고 있고 그 안에 초대장이 있는지 현금이 있는지를 알고 있고
2. 티켓오피스에 티켓이 있다는 것을 알고 있고
3. 관람객의 초대장이나 현금을 꺼내서 티켓 오피스에 넣어놓고, 그 반대도 수행한다

객체는 관련성 있는 데이터와 행동을 묶어놓은 단위이고 무엇보다 자율적이어야 한다
묻지 말고 시켜라, 묻게 된다면 그 흔적을 사방팔방에 뿌려 놓는 행위다
 */