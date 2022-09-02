## Flyweight Pattern

The Flyweight pattern is a software design pattern that is used to reduce the memory footprint of an application by
sharing as much data as possible with related objects; it is a way to use objects in large numbers when a simple
repeated representation would use an unacceptable amount of memory. Often some parts of the object state can be shared,
and it is common practice to hold them in external data structures and pass them to the objects temporarily when they
are used.

자주 변하는 속성(또는 외적인 속성, extrinsit)과 변하지 않는 속성(또는 내적인 속성,
intrinsit)을 분리하고 재사용하여 메모리 사용을 줄일 수 있다?!

![flyweight](https://user-images.githubusercontent.com/76534087/188141514-611facd1-7b41-4eeb-a4b5-255c14bead0f.jpg)

Client 예제에서 보여준 대로 매번 fontSize에 값을 할당해 주는 것이 아니라, 이미 생성된 fontSize를 재사용하는 것이다  
Integer는 -128 ~ 127까지 캐싱하고 있으므로 애플리케이션을 조금 더 가볍게 만들 수 있다  
객체를 불변으로 만들고 가능한 선택지를 다 캐싱해버림  
중복된 객체 생성을 방지해 프로그램 전체의 메모리 사용량 절약

1. 사용자가 직접 객체를 생성하지 않고 Factory를 통해 간접적으로 요청
2. Factory는 미리 생성된 객체를 재사용하여 속도 향상 & 메모리 절약