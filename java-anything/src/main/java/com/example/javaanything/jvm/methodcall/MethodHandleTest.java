package com.example.javaanything.jvm.methodcall;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {

  private static class ClassA {

    public void println(String s) {
      System.out.printf("ClassA: %s\n", s);
    }
  }

  public static void main(String[] args) throws Throwable {
    Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
    getPrintlnMH(obj).invokeExact("hello world!");
  }

  private static MethodHandle getPrintlnMH(Object receiver) throws NoSuchMethodException, IllegalAccessException {
    MethodType mt = MethodType.methodType(void.class, String.class);
    return MethodHandles.lookup()
      .findVirtual(receiver.getClass(), "println", mt)
      .bindTo(receiver);
  }
}
