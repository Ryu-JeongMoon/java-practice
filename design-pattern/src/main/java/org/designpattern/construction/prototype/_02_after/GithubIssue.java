package org.designpattern.construction.prototype._02_after;

import lombok.Data;

@Data
public class GithubIssue implements Cloneable {

	private final GithubRepository repository;

	private int id;
	private String title;

	public String getUrl() {
		return String.format("https://github.com/%s/%s/issues/%d",
			repository.username(),
			repository.name(),
			this.getId());
	}

	// intellij에서 자동으로 생성해주는 코드
	// 공변 반환을 지원하기 땜시 Object 타입 말고 해당 객체 타입으로 반환 오께이
	@Override
	public GithubIssue clone() {
		try {
			GithubIssue clone = (GithubIssue)super.clone();
			// TODO: copy mutable state here, so the clone can't change the internals of the original
			return clone;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public GithubIssue deepClone() {
		String username = "panda-bear";
		String name = "java-practice";
		GithubRepository repository = new GithubRepository(username, name);

		GithubIssue githubIssue = new GithubIssue(repository);
		githubIssue.setId(1);
		githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");
		return githubIssue;
	}
}

/*
기본적으로 자바에서 제공해주는 clone은 얕은 복사를 한다
여기서는 비교를 위해 deepClone 메서드를 따로 만들었지만
실제로는 clone 메서드에서 super.clone() 호출을 하지 않고 오버라이딩해서 사용하면 된다

primitive type은 신경 쓰지 않아도 되지만 mutable한 객체는 깊은 복사를 해줘야 한다
왜인고? mutable한 객체는 내부의 상태를 변경할 수 있기 때문이다
origin, clone 둘이 있을 때 얕은 복사 때리면
객체에 대한 참조를 복사해버리기 땜시
origin의 상태를 변경하면 clone의 상태도 변경된다
 */
