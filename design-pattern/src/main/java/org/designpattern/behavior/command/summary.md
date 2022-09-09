## Command Pattern

Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.
This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

![command](https://user-images.githubusercontent.com/76534087/189285766-8e81b581-0097-4bbd-b428-cc28afcb9f54.jpg)

리모컨의 예시  
Command -> Receiver 생성자로 전달 -> Invoker 메서드 실행
명령 (TV 끔, 켬, 소리 줄임 등등) -> 버튼 (실행기) -> 버튼 누름

### 왜 이런 구조를 가지는가?

Receiver가 직접적으로 Command에 의존한다면 명령의 변경이 필요할 때마다   
Receiver에서 Command의 API 사용하는 부분을 수정해야 한다  
Receiver는 Command에 의존하지 않게 Command를 인터페이스로 만들어 인자로 받고    
ConcreteCommand는 통일된 API로 다양한 구현을 가질 수 있둥  
Invoker는 명령이 어떻게 구현되었는지 알 필요가 없이 자신만의 실행 메서드를 수행하면 된다

Command establishes unidirectional connections between senders and receivers.