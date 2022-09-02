package org.designpattern.structure.flyweight._03_java;

public class FlyweightInJava {

    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10);
        Integer i2 = Integer.valueOf(10);
        // true
        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf(128);
        Integer i4 = Integer.valueOf(128);
        // false
        System.out.println(i3 == i4);

        // false
        System.out.println("i3 = " + System.identityHashCode(i3));
        System.out.println("i4 = " + System.identityHashCode(i4));
    }
}

/*
Integer#valueOf
This method will always cache values in the range -128 to 127, inclusive, and may cache other values outside this range.

설명이 이상함둥, -128 ~ 127 범위 외에도 캐시한다구 했는디 수동으로 캐시하라는 건가?
 */