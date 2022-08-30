package org.designpattern.structure.composite._02_after;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Bag implements Component {

	private final List<Component> components = new ArrayList<>();

	public void add(Component component) {
		components.add(component);
	}

	@Override
	public int getPrice() {
		return components.stream()
			.mapToInt(Component::getPrice)
			.sum();
	}
}

/*
기존에는 List<Item> 으로 Leaf 타입을 직접 참조하고 있었다
전체와 개별 객체를 동일하게 다루려면 둘을 공통화 & 추상화 시켜놓은 Component로 받아뿌려야 한다
 */
