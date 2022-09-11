package org.designpattern.behavior.interpreter._02_after;

import java.util.Map;

@FunctionalInterface
public interface PostfixExpression {

	static PostfixExpression plus(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) + right.interpret(context);
	}

	static PostfixExpression minus(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) - right.interpret(context);
	}

	static PostfixExpression multiply(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) * right.interpret(context);
	}

	static PostfixExpression divide(PostfixExpression left, PostfixExpression right) {
		return context -> left.interpret(context) / right.interpret(context);
	}

	static PostfixExpression variable(Character c) {
		return context -> context.get(c);
	}

	int interpret(Map<Character, Integer> context);
}
