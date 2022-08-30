## Composite Pattern

![composite](https://user-images.githubusercontent.com/76534087/187434470-df8e4ed8-067a-4430-a0bf-340ca8f4ada3.jpg)

그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴

### 요금 계산의 책임은 어디에 있어야 하는가?

객체지향 디자인에도 여러 구현 방법이 있을 수 있으나   
아래와 같은 코드가 클라이언트 쪽에 존재한다면 그리 좋은 디자인은 아닐 것이다  
이론 상은 그러한데 실무에서는 데이터 소스를 다양한 형태로 버무려야 할 수 있다  
그 때마다 도메인에 새로운 로직 추가를 할 순 없으니 복잡한 경우엔 어쩔 수 없다

```
int sum = bag.getItems().stream().mapToInt(Item::getPrice).sum();
```

### 장단점

#### 장점

1. Tree 구조로 다루기 편하다
2. 재귀 때리기 좋다
3. 새로운 Leaf가 추가되더라도 클라이언트 코드는 변경 없다 (OCP)

#### 단점

1. 지나친 일반화가 필요하다?!  

공통의 인터페이스로 묶어버리지만 Bag, Item Interface로도 제공하고 싶은 API가 있을 수 있다  
클라이언트 코드에서는 변경 가능성을 최소한으로 하기 위해 가장 추상화된 형태로 받아 쓰는데  
이러한 경우, Bag / Item Interface는 무용지물이 된다  
Bag / Item Interface 활용하려면 캐스팅 해줘야 하는데 이러면 Component로 묶는 의미가 없다

공통으로 사용해야 하니까 Component에 만들어버리고 Bag에서는 구현을 제공하지만  
Item에서는 제공할 필요 없으니 UnsupportedException 터트려버린다? -> 이것도 뻘짓 & LSP 위반
