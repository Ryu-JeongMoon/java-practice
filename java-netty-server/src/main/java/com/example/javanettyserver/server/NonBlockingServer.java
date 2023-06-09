package com.example.javanettyserver.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NonBlockingServer {

  private static final int PORT = 8888;
  private final ByteBuffer buffer = ByteBuffer.allocate(2 * 1024);
  private final Map<SocketChannel, List<byte[]>> keepDataTrack = new HashMap<>();

  public static void main(String[] args) {
    new NonBlockingServer().startEchoServer();
  }

  private void startEchoServer() {
    try (
      Selector selector = Selector.open();
      ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()
    ) {
      if (!(serverSocketChannel.isOpen() && selector.isOpen())) {
        throw new RuntimeException("THE SERVER SOCKET CHANNEL OR SELECTOR CANNOT BE OPENED!");
      }

      // ServerSocketChannel is not non-blocking by default
      // default blocking mode, serverSocketChannel.configureBlocking(false) needs to be called to make it non-blocking
      serverSocketChannel.configureBlocking(false);
      serverSocketChannel.bind(new InetSocketAddress(PORT));
      serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
      log.debug("LISTENING FOR CONNECTIONS ON PORT {}", PORT);

      //noinspection InfiniteLoopStatement
      while (true) {
        selector.select();
        Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
        while (keys.hasNext()) {
          SelectionKey key = keys.next();
          keys.remove();

          if (!key.isValid()) {
            continue;
          }

          if (key.isAcceptable()) {
            this.acceptOP(key, selector);
          } else if (key.isReadable()) {
            this.readOP(key);
          } else if (key.isWritable()) {
            this.writeOP(key);
          } else {
            log.debug("UNKNOWN OP");
          }
        }
      }

    } catch (IOException e) {
      log.debug("SERVER EXCEPTION: {}", e.getMessage());
      throw new RuntimeException(e);
    }
  }

  private void acceptOP(SelectionKey key, Selector selector) throws IOException {
    try (ServerSocketChannel channel = (ServerSocketChannel) key.channel()) {
      SocketChannel socketChannel = channel.accept();
      socketChannel.configureBlocking(false);

      log.debug("ACCEPTED CONNECTION FROM {}", socketChannel.getRemoteAddress());

      keepDataTrack.put(socketChannel, new ArrayList<>());
      socketChannel.register(selector, SelectionKey.OP_READ);
    }
  }

  private void readOP(SelectionKey key) {
    try {
      SocketChannel channel = (SocketChannel) key.channel();
      buffer.clear();

      int numRead = -1;
      try {
        numRead = channel.read(buffer);
      } catch (IOException e) {
        log.debug("CONNECTION CLOSED BY CLIENT");
      }

      if (numRead == -1) {
        this.keepDataTrack.remove(channel);
        log.debug("CONNECTION CLOSED BY CLIENT FROM : {}", channel.getRemoteAddress());
        channel.close();
        key.cancel();
        return;
      }

      byte[] data = new byte[numRead];
      System.arraycopy(buffer.array(), 0, data, 0, numRead);
      log.debug("READ {} BYTES FROM {}", numRead, channel.getRemoteAddress());
      doEchoJob(key, data);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void writeOP(SelectionKey key) throws IOException {
    SocketChannel channel = (SocketChannel) key.channel();
    Iterator<byte[]> its = keepDataTrack.get(channel).iterator();

    while (its.hasNext()) {
      byte[] it = its.next();
      its.remove();
      channel.write(ByteBuffer.wrap(it));
    }

    key.interestOps(SelectionKey.OP_READ);
  }

  private void doEchoJob(SelectionKey key, byte[] data) {
    SocketChannel channel = (SocketChannel) key.channel();
    keepDataTrack.get(channel).add(data);

    key.interestOps(SelectionKey.OP_WRITE);
  }
}

/*
nc -z localhost 8888

> Task :NonBlockingServer.main()
22:50:54.057 [main] DEBUG com.example.javanettyserver.server.NonBlockingServer - LISTENING FOR CONNECTIONS ON PORT 8888
22:50:59.239 [main] DEBUG com.example.javanettyserver.server.NonBlockingServer - ACCEPTED CONNECTION FROM /[0:0:0:0:0:0:0:1]:59051
*/
