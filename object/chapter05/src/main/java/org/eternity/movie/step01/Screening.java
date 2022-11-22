package org.eternity.movie.step01;

import java.time.LocalDateTime;

import org.eternity.money.Money;

public class Screening {

	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateMovieFee(this).times(audienceCount);
	}

	public LocalDateTime getWhenScreened() {
		return whenScreened;
	}

	public int getSequence() {
		return sequence;
	}
}

/*
문맥을 고려해 책임을 결정한다?
책임이란 협력 안에서 객체가 수행해야 할 행동이다
메세지 송신자 (Client)에게 적합한 책임을 수행해야 하는 것이고, 메세지가 객체를 선택해야 한다
메세지에 초점을 맞추면 수행할 행동에 집중할 수 있고 데이터는 부차적인 것이다
자연스레 행동을 제공하고 데이터를 숨기는 캡슐화를 얻을 수 있다

책임 주도 설계
1. 시스템이 제공해야 하는 시스템 책임 파악
2. 시스템 책임을 SRP(변경의 이유가 단 하나)를 지키는 책임으로 분할
3. 책임을 수행할 수 있는 객체 또는 역할에 할당
4. 하나의 객체 또는 역할이 모두 수행할 수 없는 경우, 다른 객체에 위임
5. 객체간 메세지를 주고 받는 유연한 협력 관계 구축

책임 할당을 어떻게 할 것인가?
1. INFORMATION EXPERT
객체는 상태와 행동을 가지는 캡슐화의 단위라 생각하고, 책임을 수행할 정보를 가진 객체에게 할당하는 방법
여기서의 정보란 객체의 상태를 의미하는 것은 아니며 상태보다 더 큰 개념의 정보를 의미한다
책임을 수행할 수 있는 다른 객체를 알고 있어도 정보를 가지고 있다고 판단한다

2. LOW COUPLING & HIGH COHESION
서로 다른 객체 간 기능을 수행할 수 있게 하는 방법은 다양하다
그 중에서 가장 나은 방법을 택할 수 있게 하는 것이 응집도와 결합도를 고려해보는 것
하나의 객체의 변경이 얼마나 많은 객체에 영향을 미치는가?

3. CREATOR
특정 객체를 생성할 책임은 누구에게 있는가?
그 객체를 긴밀히 사용하거나, 초기화하는데 필요한 데이터를 가지고 있거나, 포함하거나 참조하는 객체에게 있다

4. POLYMORPHISM
if-else 분기를 타 행동이 달라져야 하는 경우라면 타입 계층으로 묶고 구현체를 분리한다
인터페이스에서 메세지를 수신할 메서드를 선언하고 구현체에서 이를 재정의해 구현한다
단순히 if-else 분기만 없앴다는 것에 의의가 있는 것이 아니라 서로 다른 주기로 변경되더라도
클라이언트 측에는 그 영향이 미치지 않을 수 있다는 점이 중요하다
 */