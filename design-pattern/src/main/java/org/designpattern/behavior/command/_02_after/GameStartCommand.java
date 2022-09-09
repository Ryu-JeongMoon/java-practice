package org.designpattern.behavior.command._02_after;

public class GameStartCommand implements Command {

	private final Game game;

	public GameStartCommand(Game game) {
		this.game = game;
	}

	@Override
	public void execute() {
		game.start();
	}

	@Override
	public void undo() {
		new GameEndCommand(this.game).execute();
	}
}
