package org.designpattern.behavior.interpreter._02_after;

import java.util.Map;

public record VariableExpression(Character character) implements PostfixExpression {

	@Override
	public int interpret(Map<Character, Integer> context) {
		return context.get(this.character);
	}
}
