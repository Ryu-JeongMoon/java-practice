package net.jcip.examples;

public class CountingSheepRunner {

	public static void main(String[] args) throws InterruptedException {
		CountingSheep countingSheep = new CountingSheep();
		new Thread(countingSheep::tryToSleep).start();
		Thread.sleep(1000);
		countingSheep.asleep = true;
	}
}
