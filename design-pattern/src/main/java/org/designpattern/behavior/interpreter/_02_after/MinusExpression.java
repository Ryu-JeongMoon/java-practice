package org.designpattern.behavior.interpreter._02_after;

import java.util.Map;

public record MinusExpression(PostfixExpression left, PostfixExpression right) implements PostfixExpression {

	@Override
	public int interpret(Map<Character, Integer> context) {
		return left.interpret(context) - right.interpret(context);
	}
}
