package org.designpattern.behavior.command._02_after;

import java.util.Stack;

import org.designpattern.behavior.command._01_before.Light;

public class Button {

	private final Stack<Command> commands = new Stack<>();

	public static void main(String[] args) {
		Button button = new Button();
		button.press(new GameStartCommand(GameFactory.normal()));
		button.press(new LightOnCommand(new Light()));
		button.undo();
		button.undo();
	}

	public void press(Command command) {
		command.execute();
		commands.push(command);
	}

	public void undo() {
		if (!commands.isEmpty()) {
			Command command = commands.pop();
			command.undo();
		}
	}

}
