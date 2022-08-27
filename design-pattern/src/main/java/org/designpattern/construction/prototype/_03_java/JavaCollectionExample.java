package org.designpattern.construction.prototype._03_java;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionExample {

    public static void main(String[] args) {
        Student keesun = new Student("keesun");
        Student whiteship = new Student("whiteship");
        List<Student> students = new ArrayList<>();
        students.add(keesun);
        students.add(whiteship);

        List<Student> clone = new ArrayList<>(students);
        System.out.println(clone);
    }
}

/*
자바에서 기본 제공하는 clone을 List에 쓰고 싶다면 타입 캐스팅을 List 말고 ArrayList로 해야 한다.
List는 Collection -> Iterable만 상속 받는 인터페이스이기 땜시롱

자바를 사용할 때는 구현체에 의존하지 않기 위해
추상 타입으로 타입 캐스팅을 주로 하는데
ArrayList로 하면 유연성에 제약이 생긴다
따라서 List를 복사하기 위해서는 clone 대신 생성자를 사용하는 것으로 대신한다
아래와 같이 생성하면 얕은 복사가 된다
List<Student> students = new ArrayList<>();
 */
