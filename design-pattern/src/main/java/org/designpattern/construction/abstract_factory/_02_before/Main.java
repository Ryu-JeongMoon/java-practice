package org.designpattern.construction.abstract_factory._02_before;

import org.designpattern.construction.abstract_factory._01_after.domain.Ship;

class Main {

	// 배를 어떻게 만들 것인지 팩토리가 알아서 결정, 메서드에 따라 결과가 달라짐
	public static void main(String[] args) {
		Ship ship1 = new BasicShipFactory().createShip();
		System.out.println("ship1 = " + ship1);

		Ship ship2 = new BasicShipFactory().createAdvancedShip();
		System.out.println("ship2 = " + ship2);
	}
}

/*
배를 조립한다고 할 때, 닻과 바퀴가 있어야 하는데 생성 책임을 누구에게 줄 것이냐가 핵심이다
클라이언트에서 ShipFactory.createProShip()으로 던져준다 하면 팩토리 메서드 패턴을 사용하는 것이고
클라이언트에서 ShipFactory를 생성할 때 부품을 선택할 재량까지 가지고 있다면 추상 팩토리 패턴을 사용하는 것이다
*/