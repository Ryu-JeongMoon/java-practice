package org.designpattern.behavior.memento._02_after;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Originator implements Serializable {

	private int redTeamScore;

	private int blueTeamScore;

	public Memento save() {
		return new Memento(this.blueTeamScore, this.redTeamScore);
	}

	public void restore(Memento memento) {
		this.blueTeamScore = memento.blueTeamScore();
		this.redTeamScore = memento.redTeamScore();
	}
}
