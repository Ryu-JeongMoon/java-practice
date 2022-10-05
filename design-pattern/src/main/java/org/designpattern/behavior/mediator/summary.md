## Mediator Pattern

Mediator is a behavioral design pattern that lets you reduce chaotic dependencies between objects. The pattern restricts direct communications between the
objects and forces them to collaborate only via a mediator object.

<img width="1156" alt="Screenshot 2022-10-05 at 19 27 42" src="https://user-images.githubusercontent.com/76534087/194039707-1581a95d-02a8-4d83-97e1-04938c733f91.png">

특정 기능을 만들 때 여러 컴포넌트 간 협동이 필요한 경우  
각 컴포넌트가 서로를 직접 참조하는 것이 아니라 중재자를 통해 협동하도록 하는 패턴  
직접 참조하면 왜 안 되는가?, 현실의 예를 참고하면 이해가 쉽다  

1. 항공 관제사와 비행 조종사 간의 관계를 생각해보면 된다  
비행 조종사는 여러 조종사 간 직접 소통해 이/착륙을 하는 것이 아니다  
비행 조종사는 항공 관제사에게 비행을 요청하고, 항공 관제사는 비행 조종사에게 허가를 내린다  
서로 간 직접 통신을 하게 되면 복잡도가 증가하고, 관리가 어려워진다
   
2. Load Balancer, LB 또한 마찬가지로 클라이언트가 특정 서버 A 바라보고 A' 요청을 쏘고  
B 서버를 보고 B' 요청을 쏘면 매우 귀찮 & 실수 가능성이 높아진다  
앞단에서 모든 요청을 제어할 수 있는 LB가 상황에 맞게 각 서버로 요청을 분산시켜준다 

코드에서는 좀 더 유연성을 높이려면 중재자를 추상화하여 여러 중재자를 만들 수 있도록 하는 것이 좋다  
요래 하면 다양한 기능을 하는 중재자들을 만들 수 있기 때문  
협력해야 하는 컴포넌트까지 추상화하는 건 좀 오버스러울 수 있다  
그러나 컴포넌트의 기능 수정 & 추가가 많을 것으로 예상된다면 추상화해도 좋다!  

서로 협력하는 무엇이든지 직접 참조로 인해 복잡도가 너무 높아진다면 중재자 패턴을 고려해볼 수 있다
