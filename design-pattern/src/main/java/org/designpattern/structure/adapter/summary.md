## Adapter Pattern

기존 코드를 변경하지 않고 중간 계층의 구현체를 만들어  
아다리가 맞지 않는 코드들을 이어 붙여주는 역할, ex) 110V <-> 220V

예제는 spring-security에서 제공하는 UserDetails, UserDetailsService를 참고한다  
애플리케이션이 사용하는 API와 spring-security에서 제공하는 API는 일치하지 않는다  
이 상태에서 중간 계층을 하나 만들어 애플리케이션에 통합된 형태로 만들 수 있다  
이러한 패턴을 Adapter Pattern이라 한다

### 왜 이렇게 만들까?

도메인 주도 개발에 따르면 Ubiquitous Language를 사용할 수 있게 된다  
즉, 외부 API를 사용하더라도 애플리케이션에서 사용하는 용어로 해당 API의 의미를 이해할 수 있다  
외부 API에 대한 의존성을 줄일 수도 있다

### trade-off

현재 설계가 완벽한 것은 아니다, 어떠한 설계도 완벽하지 않다  
AccountService에서 직접 UserDetailsService를 구현 받을 수 있고  
이렇게 했을 때의 장점은 클래스 수가 줄고 클래스 간 관계 파악이 쉽다는 것이다  
반대로 단점은 SRP를 위반하는 형태이고 객체지향 원칙에 맞지 않다는 것이다  
자바 / 스프링을 사용한다고 해서 객체지향에 미친놈처럼 설계하면 곤란하다  
때로는 원칙을 위배한다 하더라도 실용적인 선택이 나을 수도 있다  
특히 자바 & 스프링만큼 확고한 위치에 도달한 방식이 있다면 변경 가능성이 거의 없기 때문?!
