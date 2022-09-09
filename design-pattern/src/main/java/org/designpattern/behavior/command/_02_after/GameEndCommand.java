package org.designpattern.behavior.command._02_after;

public class GameEndCommand implements Command {

	private final org.designpattern.behavior.command._02_after.Game game;

	public GameEndCommand(Game game) {
		this.game = game;
	}

	@Override
	public void execute() {
		game.end();
	}

	@Override
	public void undo() {
		new GameStartCommand(this.game).execute();
	}
}
