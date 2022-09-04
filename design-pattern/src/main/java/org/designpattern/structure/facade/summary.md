## Facade Pattern

`건물의 정면`을 의미하는 단어로 어떤 소프트웨어의 다른 커다란 코드 부분에 대하여 간략화된 인터페이스를 제공해주고, 복잡한 서브 시스템 의존성을 최소화하는 패턴

<img width="1498" alt="Screen Shot 2022-09-01 at 12 09 28" src="https://user-images.githubusercontent.com/76534087/187823794-1ffa84b7-5e26-49d2-9952-ed5c03a8ff80.png">

### 장점과 단점

#### 장점

- 서브 시스템의 변경이 클라이언트에게 영향을 미치지 않는다
- 클라이언트가 서브 시스템에 대한 의존성을 최소화할 수 있다
- 클라이언트가 관심을 가질만한 부분만 노출시킬 수 있다 (그 외에는 숨겨놓음)

#### 단점

- Facade 클래스가 서브시스템에 대한 의존성을 가질 수 밖에 없다 (조삼모사인가?)
- Facade 클래스가 많아질수록 전체 흐름을 파악하기가 복잡해질 수 있다

### 언제 쓰면 좋은가?

- 서브 시스템의 인터페이스가 복잡할 때
- 서브 시스템을 사용하는 클라이언트가 많을 때
- 서브 시스템의 인터페이스가 자주 변경될 때 or 변경될 가능성이 있을 때

java.mail만 이용한다면 `Properties`, `Session`, `Transport`, `Message` 등의 인터페이스를 모두 사용해 복잡한 생성 & 전송 과정을 거쳐야 한다  
`JavaMailSender`는 전체 과정을 간략화하여 인터페이스를 제공해주고 있다  
여기서 또 facade pattern을 사용해야 하는 이유가 무엇일까?

1. 메일 전송 구현체를 JavaMailSender가 아닌 외부 구현체를 사용하는 경우
2. 동적 조건에 따라 자바에 의존하던지, 외부 구현체에 의존하던지 하는 경우
3. JavaMailSender 사용법 보다 더 간편한 사용법을 만들고 싶은 경우

복잡한 구현이나 연관 관계를 감추고, 단순한 인터페이스를 제공해주는 것이 facade pattern의 목적이다  
구현 자체는 어쩔 수 없이 모든 의존성을 알고 지식도 알고 있어야 하지만  
클라이언트 입장에서는 그런건 모르겠고 단순하게 사용만 할 수 있으면 된다