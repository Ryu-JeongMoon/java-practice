package net.jcip.examples;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * TaskExecutionWebServer
 * <p/>
 * Web server using a thread pool
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TaskExecutionWebServer {

  private static final int N_THREADS = 100;
  private static final Executor EXECUTOR = Executors.newFixedThreadPool(N_THREADS);

  // task submission / execution -> EXECUTOR 를 통해 분리
  public static void main(String[] args) throws IOException {
    try (ServerSocket socket = new ServerSocket(80)) {
      while (true) {
        final Socket connection = socket.accept();
        Runnable task = () -> handleRequest(connection);
        EXECUTOR.execute(task);
      }
    }
  }

  private static void handleRequest(Socket connection) {
    // request-handling logic here
  }
}
