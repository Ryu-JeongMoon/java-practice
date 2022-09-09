package org.designpattern.behavior.command._02_after;

public class MyApp {

	private final Command command;

	public MyApp(Command command) {
		this.command = command;
	}

	public static void main(String[] args) {
		MyApp myApp = new MyApp(new GameStartCommand(GameFactory.easy()));
		myApp.press();
	}

	public void press() {
		command.execute();
	}
}
