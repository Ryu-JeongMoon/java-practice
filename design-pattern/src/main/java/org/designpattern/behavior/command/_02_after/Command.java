package org.designpattern.behavior.command._02_after;

public interface Command {

	void execute();

	void undo();

}

/*
execute()만 존재한다면 Runnable을 활용할 수 있다
Command라는 애플리케이션 전용 인터페이스를 별도로 만든다면 다음과 같은 장점이 있다

1. Ubiquitous Language로 사용
2. undo()와 같이 추가적인 기능 제공 가능
3. Command를 메서드 인자로 제한 (Runnable은 너무 포괄적임둥)
 */