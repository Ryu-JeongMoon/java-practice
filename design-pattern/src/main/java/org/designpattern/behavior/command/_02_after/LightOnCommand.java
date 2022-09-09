package org.designpattern.behavior.command._02_after;

import org.designpattern.behavior.command._01_before.Light;

public class LightOnCommand implements Command {

	private final Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.on();
	}

	@Override
	public void undo() {
		new LightOffCommand(this.light).execute();
	}
}
