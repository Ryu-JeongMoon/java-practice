## Iterator Pattern

Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

![iterator](https://user-images.githubusercontent.com/76534087/192100785-00f30b5c-97f2-491a-b1d2-959b264e8433.jpg)

### 왜 쓰는가?

OCP를 지켜 Aggregate 객체 내부를 다양한 이유로 변경하더라도 클라이언트의 변경을 유발하지 않는다.   
클라이언트를 세부사항에 결합하지 않고 추상화한 형태인 Iterator로 접근하게 만들어 유연성을 키우는 것이다.  
Collection 구현체들이 각자 다양한 기능을 지원하더라도 가장 기본적인 책임은 데이터에 대한 컨테이너인 것이다.  
Iterator를 쓰면 아래와 같은 형태로 작성해야 해서 직관적이지 않다는 단점이 있다.  
Iterator를 써서 얻게 되는 이점이 List, Map, Set 등을 직접 돌리는 것보다 나은 점이 있을 때만 사용하는 것이 옳다.
remove() 같은 메서드를 사용할 때는 구현체가 remove()를 구현해 놨는지 확인 후 써야한다.
```
Iterator it = collection.iterator();
while(it.hasNext()) {
    Object obj = it.next();
    // do something
}
```

<hr>

또한 보안 관련 이유로 내부 구조를 드러내고 싶지 않을 때도 사용할 수 있다.  
간단히 정리하면 내부구조를 신경쓰지 않게 하며 순회하는 방법만 제공하는 것이다.  
성능 향상으로 내부 구현체를 바꿀 때 사용하면 요긴할 듯 하지만  
이미 Stream API로 각종 Collection들을 손 쉽게 다룰 수 있고  
List, Set, Map 등의 중간 인터페이스로 다루니 실효성이 있을 것인가 고민해봐야 한다  
```
ArrayList -> LinkedList 등 특정 인터페이스의 구현체 간 변환 말고
List -> Set, Set -> Map 등 자료 구조 인터페이스 간의 변환이 있을 것인가?
```
