## Memento Pattern (Snapshot Pattern)

Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.

![memento](https://user-images.githubusercontent.com/76534087/194768159-0f48ddd6-a91d-4aa6-83b0-6b0de1875136.jpg)

### 언제 쓰는가?

- 객체의 상태를 저장하고 싶을 때
- 특정 객체의 상태를 저장하고 싶지만, 객체의 구현에 대해서는 신경쓰고 싶지 않을 때

Originator 객체가 있을 때, 상태를 바꾸고 자시고 하는 것은 모두 Originator에 의해 수행되지만 상태를 저장하는 역할은 Memento에 의해 수행된다  
Originator는 저장하고자 하는 상태 혹은 상태가 변경될 때마다 Memento에게 상태를 저장하라고 요청한다  
Memento는 불변으로 만들어 값 객체로 사용한다, Originator가 상태를 변경해도 Memento에는 영향을 미치지 않는다  
Memento는 생성자로 Originator의 상태를 받아서 저장한다, rollback 기능을 구현할 때 사용한다

다만 사용은 제한적으로 해야한다

1. 수 많은 Memento 객체에 의해 RAM 사용이 늘어난다
2. Memento 객체가 너무 많아지면 Garbage Collection이 느려짐 & 성능 저하
3. CareTaker가 History를 관리하는데 이 놈 역시 RAM 사용 많아짐
4. CareTaker가 적절한 수로 History를 유지하기 위해선 Originator를 추적하여 GC 처리된 놈들은 걸러내야 함  
   그럼 CareTaker는 Originator, History 모두 추적해야 하므로 복잡해짐?!