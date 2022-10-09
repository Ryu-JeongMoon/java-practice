package org.designpattern.behavior.memento._02_after;

public class CareTaker {

	public static void main(String[] args) {
		Originator originator = new Originator();
		originator.setBlueTeamScore(10);
		originator.setRedTeamScore(20);

		Memento save = originator.save();

		originator.setBlueTeamScore(12);
		originator.setRedTeamScore(22);

		originator.restore(save);

		System.out.println(originator.getBlueTeamScore());
		System.out.println(originator.getRedTeamScore());
	}
}
