package com.example.javaanything.jvm.methodcall;

public class StaticResolution {

  public static void sayHello() {
    System.out.println("Hello, world!");
  }

  public static void main(String[] args) {
    StaticResolution.sayHello();
  }
}
