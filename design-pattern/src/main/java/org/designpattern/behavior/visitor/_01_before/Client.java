package org.designpattern.behavior.visitor._01_before;

public class Client {

	public static void main(String[] args) {
		Shape rectangle = new Rectangle();
		Device device = new Phone();
		rectangle.printTo(device);
	}
}
