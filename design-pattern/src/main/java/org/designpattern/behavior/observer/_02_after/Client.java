package org.designpattern.behavior.observer._02_after;

public class Client {

	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		User user1 = new User("panda");
		User user2 = new User("bear");

		String squidGame = "오징어게임";
		chatServer.register(squidGame, user1);
		chatServer.register(squidGame, user2);
		chatServer.sendMessage(user1, squidGame, "재밌당");

		String designPattern = "디자인패턴";
		chatServer.register(designPattern, user1);
		chatServer.sendMessage(user2, designPattern, "chat designed by observer pattern");

		chatServer.unregister(designPattern, user1);
		chatServer.sendMessage(user2, designPattern, "unregister 했응게 여긴 안 나올거 임둥");
	}
}
