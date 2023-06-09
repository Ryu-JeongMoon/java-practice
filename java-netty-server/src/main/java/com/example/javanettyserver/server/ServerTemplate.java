package com.example.javanettyserver.server;

import jakarta.annotation.Nonnull;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ServerTemplate {

  static void work(final ChannelHandler... handlers) {
    NioEventLoopGroup accepterGroup = new NioEventLoopGroup(1);
    NioEventLoopGroup workerGroup = new NioEventLoopGroup();

    try {
      new ServerBootstrap()
        .group(accepterGroup, workerGroup)
        .channel(NioServerSocketChannel.class)
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          public void initChannel(@Nonnull SocketChannel ch) {
            ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
            ch.pipeline().addLast(handlers);
          }
        })
        .bind(8888).sync()
        .channel().closeFuture().sync();

    } catch (InterruptedException e) {
      log.error("EXCEPTION OCCURRED", e);
      throw new RuntimeException(e);
    } finally {
      workerGroup.shutdownGracefully();
      accepterGroup.shutdownGracefully();
    }
  }
}

/*
1. create bootstrap for server
2. designate event handling thread model
3. designate transmission mode (blocking / non-blocking)
4. designate handler to process accepted connection
5. designate port to listen
6. wait until server socket is closed
*/
