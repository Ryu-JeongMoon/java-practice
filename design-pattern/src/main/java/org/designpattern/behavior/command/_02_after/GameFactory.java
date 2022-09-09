package org.designpattern.behavior.command._02_after;

public class GameFactory {

	public static Game normal() {
		return new DefaultGame();
	}

	public static Game easy() {
		return new EasyGame(normal());
	}

	public static Game hard() {
		return new HardGame(normal());
	}
}
