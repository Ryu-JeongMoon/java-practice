package com.example.javaanything.exception;

public class Test {

  public static void main(String[] args) {
    try {
      throwNested(-1);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void throwNested(int i) {
    throwIntentionally(i);
  }

  static void throwIntentionally(int i) {
    if (i < 0) {
      throw SubException.INSTANCE;
    }
  }
}
