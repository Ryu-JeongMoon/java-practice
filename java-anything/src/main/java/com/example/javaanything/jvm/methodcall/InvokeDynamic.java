package com.example.javaanything.jvm.methodcall;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InvokeDynamic {

  static class GrandFather {

    void thinking() {
      System.out.println("I am a grandfather.");
    }
  }

  static class Father extends GrandFather {

    @Override
    void thinking() {
      System.out.println("I am a father.");
    }
  }

  static class Son extends Father {

    @Override
    void thinking() {
      // super.thinking();
      // MethodHandle을 이용한 다이나믹 디스패치
      try {
        var methodHandle = MethodHandles.lookup()
          .findSpecial(GrandFather.class, "thinking", MethodType.methodType(void.class), getClass());
        methodHandle.invoke(this);
      } catch (Throwable e) {
        log.error("error : ", e);
      }
    }
  }

  // jdk7 update 10 이후로는 부모 클래스까지만 접근 가능하므로 GrandFather#thinking 메서드 호출 불가
  public static void main(String[] args) {
    GrandFather grandFather = new GrandFather();
    grandFather.thinking();

    Father father = new Father();
    father.thinking();

    Son son = new Son();
    son.thinking();
  }
}
