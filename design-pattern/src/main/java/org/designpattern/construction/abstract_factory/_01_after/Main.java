package org.designpattern.construction.abstract_factory._01_after;

import org.designpattern.construction.abstract_factory._01_after.domain.Ship;
import org.designpattern.construction.abstract_factory._01_after.factory.AdvancedPartsFactory;
import org.designpattern.construction.abstract_factory._01_after.factory.AdvancedShipFactory;
import org.designpattern.construction.abstract_factory._01_after.factory.BasicPartsFactory;

public class Main {

	// 부품을 어떻게 만들 것인지 클라이언트가 결정, 부품을 만드는 부분을 추상화
	public static void main(String[] args) {
		AdvancedShipFactory factory1 = new AdvancedShipFactory(new BasicPartsFactory());
		Ship ship1 = factory1.createShip();
		System.out.println("ship1 = " + ship1);

		AdvancedShipFactory factory2 = new AdvancedShipFactory(new AdvancedPartsFactory());
		Ship ship2 = factory2.createShip();
		System.out.println("ship2 = " + ship2);
	}
}

/*
팩토리 메서드 패턴은 어떻게 구현할지에 대해 초점이 맞춰져 있다
이 팩토리를 사용하는 입장에서는 어떻게 구현 됐는지 신경쓰지 않고 메서드 별로 사용할 수 있다

추상 팩토리 패턴은 팩토리를 사용하는 방법 (composition)에 초점이 맞춰져 있다
말 그대로 어떤 것을 생성할 때 기본적인 뼈대는 추상 클래스나 인터페이스 형태로 만들어두고
구현체를 사용하는 측에서 선택할 수 있도록 하는 패턴이기 때문이다

추상 팩토리 패턴의 단점은 드럽게 복잡하다는 것
굳이 이 정도까지 추상화를 해야 하는가에 대한 의문이 들 수도 있다
하지만 이런 패턴을 사용하면 클라이언트 코드를 깔끔하게 유지할 수 있다?!

구현체가 자주 바뀌어야 하거나 많은 게 아니라면
다른 메서드로 구현체를 바꿔서 내보내는 게 낫지 않을까 싶은디
대규모 프로젝트라면 추상 팩토리 패턴을 고려 해볼만 한 것 같다
 */