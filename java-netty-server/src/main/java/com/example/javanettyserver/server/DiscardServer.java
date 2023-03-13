package com.example.javanettyserver.server;

import com.example.javanettyserver.handler.DiscardServerHandler;

public class DiscardServer {

	public static void main(String[] args) {
		ServerTemplate.work(new DiscardServerHandler());
	}
}
