package net.jcip.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ThreadPerTaskWebServer
 * <p/>
 * Web server that starts a new thread for each request
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ThreadPerTaskWebServer {

  public static void main(String[] args) throws IOException {
    try (ServerSocket socket = new ServerSocket(80)) {
      while (true) {
        final Socket connection = socket.accept();
        Runnable task = () -> handleRequest(connection);
        new Thread(task).start();
      }
    }
  }

  private static void handleRequest(Socket connection) {
    // request-handling logic here
  }
}

/*
사용자의 요청마다 새로운 스레드를 생성하여 처리한다
1. 작업 처리 기능이 메인 스레드에서 분리됨
2. 작업 처리 기능이 병렬적으로 실행됨
3. 작업 처리 기능이 독립적으로 실행됨

새로운 클라이언트가 요청 하는 속도 < 작업 처리 속도가 빨라야 한다는 전제가 필요하다
또한 이 방식은 스레드 생성 비용이 크기 때문에 적절한 스레드 풀을 사용하는 것이 좋다

1. Thread Life-Cycle
스레드 생성에는 JVM, OS 비용이 존재한다
2. Resource Waste
CPU core 수 이상의 스레드를 생성해봤자 실행되는 스레드는 CPU core 수 만큼이다
따라서 CPU core 이상의 스레드는 메모리만 잡아먹는 것
3. Stability
JVM 할당된 메모리가 부족하면 OutOfMemoryError가 발생한다
 */