package org.designpattern.behavior.template._02_after;

public class Plus implements Operator {

	@Override
	public int getResult(int result, int number) {
		return result + number;
	}
}
