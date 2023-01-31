package org.designpattern.behavior.strategy._03_java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StrategyInJava {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>(List.of(10, 5));
		System.out.println(numbers);

		numbers.sort(Comparator.naturalOrder());
		System.out.println(numbers);
	}
}
