package org.designpattern.behavior.observer._02_after;

public interface Subscriber {

	void handleMessage(String name, String message);

	String name();
}
