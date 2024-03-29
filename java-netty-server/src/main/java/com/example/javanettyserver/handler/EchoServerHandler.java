package com.example.javanettyserver.handler;

import java.nio.charset.Charset;

import jakarta.annotation.Nonnull;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void channelRead(ChannelHandlerContext ctx, @Nonnull Object msg) {
    String readMessage = ((ByteBuf) msg).toString(Charset.defaultCharset());
    log.debug("[1] RECEIVED MESSAGE : {}", readMessage);
    ctx.write(msg);
    ctx.fireChannelRead(msg);
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    log.debug("[1] CHANNEL_READ_COMPLETE CALLED");

    // ctx.fireChannelRead() + ctx.flush() invokes io.netty.util.IllegalReferenceCountException
    // so it should be inactivated when the event was passed to the next handler
    // ctx.flush();
  }
}

/*
if you want to pass the event to the next handler, you should call fireChannelRead() method
*/
