package org.designpattern.behavior.command._02_after;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EasyGame implements Game {

	private final Game delegator;

	@Override
	public void start() {
		System.out.println("쉬운");
		delegator.start();
	}

	@Override
	public void end() {
		System.out.println("쉬운");
		delegator.end();
	}
}
