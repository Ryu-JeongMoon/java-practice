package org.designpattern.construction.factory_method;

public class Main {

	public static void main(String[] args) {
		PandaShipFactory pandaShipFactory = new PandaShipFactory();
		Ship pandaShip = pandaShipFactory.orderShip("panda ship", "panda@gmail.com");
		System.out.println("pandaShip = " + pandaShip);

		BearShipFactory bearShipFactory = new BearShipFactory();
		Ship bearShip = bearShipFactory.orderShip("panda ship", "panda@gmail.com");
		System.out.println("bearShip = " + bearShip);
	}
}

/*
Factory Method Pattern, 왜 쓰는 것일까?
OCP (Open Closed Principle) 지키기 위함
새로운 기능이 추가되더라도 코드를 수정하지 않아도 됨
if-else 대신 다형성을 사용할 수 있기 때문임둥
다만 클라이언트 코드는 변경해야 하는데 이 역시 팩토리 메서드 패턴을 사용해 OCP 지킬 수 있둥

그냥 인터페이스 기반으로 다형성을 활용하는 대신 팩토리 메서드 패턴을 써야하는 이유가 무엇인고?
생성 시에 일정한 Flow를 따르도록 강제할 수 있기 때문임둥
아래 메서드처럼 상위 클래스 또는 인터페이스에서 생성 흐름을 정해두고
하위 클래스, 구현 클래스에서 이를 작성하도록 강제함
인터페이스 기반으로만 작성하면 매번 노가다를 해줘야 하는데
패턴 사용 시 default method 이용하거나 Abstract Skeleton Class 이용해서 간편하게 작성할 수 있둥

default Ship orderShip(String name, String email) {
	validate(name, email);
	prepareFor(name);
	Ship ship = createShip();
	sendEmailTo(email, ship);
	return ship;
}
 */