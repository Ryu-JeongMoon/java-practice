package com.example.javanettyserver.handler;

import java.nio.charset.Charset;

import jakarta.annotation.Nonnull;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoServerHandler2 extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, @Nonnull Object msg) {
    String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());
    log.debug("[2] RECEIVED MESSAGE : {}", readMessage);
    ctx.write(msg);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    log.debug("[2] CHANNEL_READ_COMPLETE CALLED");
    ctx.flush();
  }
}
