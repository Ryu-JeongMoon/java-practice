## Bridge Pattern

추상적인 것과 구체적인 것을 분리하여 각각 독립적으로 변형할 수 있도록 하는 패턴이다.  
패턴은 보는 시각에 따라 달라질 수 있다. 파사드 패턴과 유사하다.     
파사드 패턴은 인터페이스를 통해 기능을 제공하는 것이고 브릿지 패턴은 인터페이스를 통해 기능을 분리하는 것이다.

![bridge-pattern](https://user-images.githubusercontent.com/76534087/187161166-ceb4456f-6051-419e-b272-60b64a98a738.jpg)

TransactionTemplate <-> PlatformTransactionManager 에서도 찾아볼 수 있다  
TransactionTemplate은 Client Code이고 PlatformTransactionManager은 인터페이스다
TransactionTemplate을 건드리지 않고도 PlatformTransactionManager의 구현체들을 변경해 새로운 기능을 제공할 수 있다

Logger도 마찬가지로 Logging의 파사드로써 Slf4j가 있고 Log4j, Log4j2, Logback 등의 구현체가 있다  
이 역시 Logger를 건드리지 않고 구현체를 변경할 수 있다
