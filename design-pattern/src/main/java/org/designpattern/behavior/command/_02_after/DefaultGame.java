package org.designpattern.behavior.command._02_after;

public class DefaultGame implements Game {

	@Override
	public void start() {
		System.out.println("게임을 시작하지");
	}

	@Override
	public void end() {
		System.out.println("게임을 끝내지");
	}
}
