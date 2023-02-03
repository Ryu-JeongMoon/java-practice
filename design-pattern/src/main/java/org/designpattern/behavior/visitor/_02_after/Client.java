package org.designpattern.behavior.visitor._02_after;

public class Client {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle();
		Device device = new Pad();
		rectangle.accept(device);
	}
}
