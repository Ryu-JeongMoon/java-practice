package com.example.javanettyserver.server;

import com.example.javanettyserver.handler.EchoServerHandler;
import com.example.javanettyserver.handler.EchoServerHandler2;

public class EchoServer {

  public static void main(String[] args) {
    ServerTemplate.work(new EchoServerHandler(), new EchoServerHandler2());
  }
}

/*
the first handler handles the event if there is same event handler that handles specific event in the pipeline
in this situation, EchoServerHandler handles the event only
 */
