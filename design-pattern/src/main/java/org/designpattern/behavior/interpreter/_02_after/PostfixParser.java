package org.designpattern.behavior.interpreter._02_after;

import static org.designpattern.behavior.interpreter._02_after.PostfixExpression.*;

import java.util.Stack;

public class PostfixParser {

	public static PostfixExpression parse(String expression) {
		Stack<PostfixExpression> stack = new Stack<>();
		for (char c : expression.toCharArray()) {
			stack.push(getExpression(c, stack));
		}
		return stack.pop();
	}

	private static PostfixExpression getExpression(char c, Stack<PostfixExpression> stack) {
		return switch (c) {
			case '+' -> plus(stack.pop(), stack.pop());
			case '-' -> {
				PostfixExpression right = stack.pop();
				PostfixExpression left = stack.pop();
				yield minus(left, right);
			}
			case '*' -> multiply(stack.pop(), stack.pop());
			case '/' -> {
				PostfixExpression right = stack.pop();
				PostfixExpression left = stack.pop();
				yield divide(left, right);
			}
			default -> variable(c);
		};
	}
}
