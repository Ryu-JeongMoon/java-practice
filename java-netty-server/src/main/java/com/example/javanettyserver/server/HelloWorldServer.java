package com.example.javanettyserver.server;

import io.netty.handler.codec.http.HttpServerCodec;

import com.example.javanettyserver.handler.HelloWorldServerHandler;

public class HelloWorldServer {

  public static void main(String[] args) {
    ServerTemplate.work(new HttpServerCodec(), new HelloWorldServerHandler());
  }
}
