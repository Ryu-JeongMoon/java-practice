package net.jcip.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SingleThreadWebServer
 * <p/>
 * Sequential web server
 *
 * @author Brian Goetz and Tim Peierls
 */

public class SingleThreadWebServer {

	public static void main(String[] args) throws IOException {
		// 한번에 하나의 요청만 처리 가능한 웹 서버
		try (ServerSocket socket = new ServerSocket(80)) {
			while (true) {
				Socket connection = socket.accept();
				handleRequest(connection);
			}
		}
	}

	private static void handleRequest(Socket connection) {
		// request-handling logic here
	}
}

/*
실제로 한번에 하나의 요청만 처리하는 서버는 거의 무의미하다고 볼 수 있다
다만 GUI 프레임워크 같은 경우 사용자의 이벤트를 처리할 단일 스레드에서 순차적으로 처리할 수 있다
 */