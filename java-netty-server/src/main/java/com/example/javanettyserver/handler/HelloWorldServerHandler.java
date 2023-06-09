package com.example.javanettyserver.handler;

import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.*;

import jakarta.annotation.Nonnull;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpUtil;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {

  private static final byte[] CONTENT = { 'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd' };

  @Override
  public void channelRead(@Nonnull ChannelHandlerContext ctx, @Nonnull Object msg) {
    if (msg instanceof HttpMessage message) {
      if (HttpUtil.is100ContinueExpected(message)) {
        ctx.write(new DefaultFullHttpResponse(HTTP_1_1, CONTINUE));
      }

      DefaultFullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(CONTENT));
      response.headers()
        .set(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE)
        .setInt(HttpHeaders.CONTENT_LENGTH, CONTENT.length);

      if (!HttpUtil.isKeepAlive(message)) {
        ctx.write(response).addListener(future -> ctx.close());
      } else {
        response.headers().set(HttpHeaders.CONNECTION, "keep-alive");
        ctx.write(response);
      }
    }
  }

  @Override
  public void channelReadComplete(ChannelHandlerContext ctx) {
    ctx.flush();
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    cause.printStackTrace();
    ctx.close();
  }
}
