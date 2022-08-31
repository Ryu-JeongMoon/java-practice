package org.designpattern.structure.decorator._03_java;

import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;

public class DecoratorInSpring {

  public static void main(String[] args) {
    // 빈 설정 데코레이터
    BeanDefinitionDecorator decorator;

    // 웹플럭스 HTTP 요청 /응답 데코레이터
    ServerHttpRequestDecorator httpRequestDecorator;
    ServerHttpResponseDecorator httpResponseDecorator;
  }

  @Bean
  @ConditionalOnExpression("1 + 1 == 2")
  public String yahoo() {
    return "yahoo!";
  }
}
