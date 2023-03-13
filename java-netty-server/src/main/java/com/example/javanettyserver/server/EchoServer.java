package com.example.javanettyserver.server;

import com.example.javanettyserver.handler.EchoServerHandler;

public class EchoServer {

	public static void main(String[] args) {
		ServerTemplate.work(new EchoServerHandler());
	}
}
