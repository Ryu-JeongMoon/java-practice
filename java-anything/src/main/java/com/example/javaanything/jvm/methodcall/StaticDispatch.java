package com.example.javaanything.jvm.methodcall;

public class StaticDispatch {

  static abstract class Human {

  }

  static class Man extends Human {

  }

  static class Woman extends Human {

  }

  void sayHello(Human human) {
    System.out.println("Hello, human!");
  }

  void sayHello(Man man) {
    System.out.println("Hello, man!");
  }

  void sayHello(Woman woman) {
    System.out.println("Hello, woman!");
  }

  public static void main(String[] args) {
    StaticDispatch staticDispatch = new StaticDispatch();

    // 컴파일 타임에 정적 타입에 따라 호출될 메서드가 지정됨 (invokevirtual)
    Human man1 = new Man();
    Human woman1 = new Woman();
    staticDispatch.sayHello(man1);
    staticDispatch.sayHello(woman1);

    Man man2 = new Man();
    Woman woman2 = new Woman();
    staticDispatch.sayHello(man2);
    staticDispatch.sayHello(woman2);

    // var 타입은 런타임에 추론되므로 정적 타입을 이용한 다형성 X
    var man3 = new Man();
    var woman3 = new Woman();
    staticDispatch.sayHello(man3);
    staticDispatch.sayHello(woman3);
  }
}
