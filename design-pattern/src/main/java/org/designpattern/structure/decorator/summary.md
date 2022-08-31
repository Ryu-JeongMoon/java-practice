## Decorator Pattern

기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴이자  
기존 클래스에 래퍼를 제공하는 구조적 패턴

<img width="580" alt="Screen Shot 2022-08-31 at 20 06 09" src="https://user-images.githubusercontent.com/76534087/187664818-69645c36-8472-459f-8e97-90d7b51fc6d3.png">

중심이 되는 객체가 있고 그 위에 장식을 더하는 패턴  
본 장의 예제에서는 `CommentService`가 중심이 되는 객체이고  
`SpamFilteringCommentService`, `TrimmingCommentService`가 장식을 더하는 객체  
ConcreteComponent-> CommentService  
Decorator -> CommentDecorator   
Concrete Decorator -> SpamFilteringCommentService, TrimmingCommentService

CommentService가 제공할 API 가진 Interface -> Component  
ConcreteDecorator들이 공통적으로 제공할 API 가진 Interface -> Decorator

기본 객체에 메세지 전송하는 것과 장식에 메세지 전송하는 것을 동일한 형태로 본다  
`*장식*` + 기본 객체의 결과값 + `*장식*`

1. 장식은 내부적으로 기본 객체를 가지고 있고
2. 자신만의 장식을 더한 후
3. indirection으로 기본 객체에서 받아온 응답을 전달한다

<hr/>

### 동적 선택으로 런타임에 객체를 생성해야 한다

이게 최선일까..?!

```
CommentService commentService = new DefaultCommentService();

if (enabledSpamFilter) {
  commentService = new SpamFilteringCommentDecorator(commentService);
}

if (enabledTrimming) {
  commentService = new TrimmingCommentDecorator(commentService);
}
```

<hr/>

### 언제 써야 하는가?

1. 객체의 동작이나 상태를 추가, 향상 또는 제거하려는 경우
2. 클래스의 단일 객체 기능을 수정하고 다른 객체는 변경하지 않으려는 경우
