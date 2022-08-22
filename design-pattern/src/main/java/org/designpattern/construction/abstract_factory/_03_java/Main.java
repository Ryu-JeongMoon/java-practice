package org.designpattern.construction.abstract_factory._03_java;

import org.designpattern.construction.abstract_factory._01_after.domain.Ship;
import org.designpattern.construction.abstract_factory._01_after.factory.ShipFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 1. 팩토리를 직접 가져옴
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
		ShipFactory shipFactory = applicationContext.getBean(ShipFactory.class);
		Ship ship1 = shipFactory.createShip();
		System.out.println("ship1 = " + ship1);

		// 2. FactoryBean 내부에서 생성해주는 인스턴스를 스프링 컨테이너에서 직접 가져옴
		Ship ship2 = applicationContext.getBean(Ship.class);
		System.out.println("ship2 = " + ship2);
	}
}

/*
java, spring 내부에서 사용하는 FactoryBean<T> 사용 예제, 이거 쓸 일은 거의 없슴둥
팩토리를 가져오거나, 팩토리에서 만들어진 인스턴스를 가져오는 두 방식 모두 사용 가능
 */