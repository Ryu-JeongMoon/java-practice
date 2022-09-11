package org.designpattern.behavior.interpreter._02_after;

import java.util.Map;

public class App {

	public static void main(String[] args) {
		PostfixExpression expression = PostfixParser.parse("xyz+-a+");
		int result = expression.interpret(Map.of('x', 8, 'y', 9, 'z', 10, 'a', 19));
		System.out.println(result);
	}
}
