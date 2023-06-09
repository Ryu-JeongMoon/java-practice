package com.example.javanettyserver.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockingServer {

  public static void main(String[] args) throws IOException {
    new BlockingServer().run();
  }

  private void run() throws IOException {
    try (
      ServerSocket server = new ServerSocket(8888);

      // blocking point-1
      Socket socket = server.accept();
      OutputStream out = socket.getOutputStream();
      InputStream in = socket.getInputStream()
    ) {
      log.debug("ACCEPTED CONNECTION FROM {}", socket);

      for (; ; ) {
        try {
          // blocking point-2
          int request = in.read();
          out.write(request);
        } catch (IOException e) {
          log.debug("CONNECTION CLOSED BY CLIENT");
          break;
        }
      }
    }
  }
}

/*
nc -z localhost 8888

> Task :BlockingServer.main()
22:39:49.703 [main] DEBUG com.example.javanettyserver.server.BlockingServer - Accepted connection from Socket[addr=/0:0:0:0:0:0:0:1,port=58010,localport=8888]
22:39:49.709 [main] DEBUG com.example.javanettyserver.server.BlockingServer - CONNECTION CLOSED BY CLIENT
*/
