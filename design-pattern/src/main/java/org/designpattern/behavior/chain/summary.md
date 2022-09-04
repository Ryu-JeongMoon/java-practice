## Chain Of Responsibility Pattern

Chain Of Responsibility Pattern is a behavioral design pattern that lets you pass requests along a chain of handlers.
Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the
chain.

![chain](https://user-images.githubusercontent.com/76534087/188301686-84ca2da9-2de9-4e1f-9863-a940a6543fba.jpg)

객체를 조합한다는 점에서 Composite Pattern과 유사하지만
Chain Of Responsibility Pattern은 객체를 트리 구조로 구성하는 것이 아니라 선형 구조로 구성한다는 점에서 차이가 있다.

로깅, 인증&인가 처리 등의 작업을 처리할 때 유용하다  
대표적인 예로 Spring Security가 거대한 Filter Chain을 구성하여 요청을 처리한다  
거기에 더해 확장 포인트를 열어두어 명시적인 필터 뒤에 추가하는 것이 아니라  
설정 클래스에서 필터를 추가할 수 있게 해놨다

```java

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) {
		http
			.authorizeRequests().anyRequest().permitAll()
			.and()

			.addFilter(new LoggingFilter())
			.addFilterBefore(new AuthFilter(), LoggingFilter.class)
			.addFilterAfter(new PrintFilter(), AuthFilter.class)
			.addFilterAt(new SomeFilter(), LoggingFilter.class);
	}
}
```

<hr>

Like many other behavioral design patterns, the Chain of Responsibility relies on transforming particular behaviors into
stand-alone objects called handlers. In our case, each check should be extracted to its own class with a single method
that performs the check. The request, along with its data, is passed to this method as an argument.

The pattern suggests that you link these handlers into a chain. Each linked handler has a field for storing a reference
to the next handler in the chain. In addition to processing a request, handlers pass the request further along the
chain. The request travels along the chain until all handlers have had a chance to process it.

Here’s the best part: a handler can decide not to pass the request further down the chain and effectively stop any
further processing.