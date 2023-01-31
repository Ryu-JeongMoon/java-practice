package org.designpattern.behavior.strategy._01_before;

public class Client {

	public static void main(String[] args) {
		BlueLightRedLight blueLightRedLight = new BlueLightRedLight(1);
		blueLightRedLight.blueLight();
		blueLightRedLight.redLight();
	}
}
