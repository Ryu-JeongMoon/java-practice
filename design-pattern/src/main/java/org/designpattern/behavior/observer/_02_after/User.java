package org.designpattern.behavior.observer._02_after;

public record User(String name) implements Subscriber {

	@Override
	public void handleMessage(String name, String message) {
		System.out.printf("%s received the message\n%s\n", name, message);
	}
}
