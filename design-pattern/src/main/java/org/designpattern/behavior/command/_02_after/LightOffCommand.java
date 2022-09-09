package org.designpattern.behavior.command._02_after;

import org.designpattern.behavior.command._01_before.Light;

public class LightOffCommand implements Command {

	private final Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	@Override
	public void execute() {
		light.off();
	}

	@Override
	public void undo() {
		new LightOnCommand(this.light).execute();
	}
}
