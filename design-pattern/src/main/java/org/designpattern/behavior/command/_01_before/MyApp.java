package org.designpattern.behavior.command._01_before;

public class MyApp {

	private final Game game;

	public MyApp(Game game) {
		this.game = game;
	}

	public void press() {
		game.start();
	}

	public static void main(String[] args) {
		Button button = new Button(new Light());
		button.press();
		button.press();
		button.press();
		button.press();
	}
}
