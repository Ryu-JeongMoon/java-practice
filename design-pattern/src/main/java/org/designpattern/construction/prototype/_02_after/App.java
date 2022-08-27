package org.designpattern.construction.prototype._02_after;

public class App {

	public static void main(String[] args) {
		String username = "panda-bear";
		String name = "java-practice";
		GithubRepository repository = new GithubRepository(username, name);

		GithubIssue origin = new GithubIssue(repository);
		origin.setId(1);
		origin.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

		String url = origin.getUrl();
		System.out.println(url);

		GithubIssue clone = (GithubIssue)origin.clone();
		System.out.println("(origin == clone) = " + (origin == clone));
		System.out.println("(origin.equals(clone)) = " + (origin.equals(clone)));

		GithubIssue deepClone = origin.deepClone();
		System.out.println("(origin == deepClone) = " + (origin == deepClone));
		System.out.println("(origin.equals(deepClone)) = " + (origin.equals(deepClone)));

		System.out.println("============shallow copy versus deep copy============");
		System.out.println("(origin.getRepository() == clone.getRepository()) = " + (origin.getRepository() == clone.getRepository()));
		System.out.println("(origin.getRepository() == deepClone.getRepository()) = " + (origin.getRepository() == deepClone.getRepository()));
	}
}

/*
기존 인스턴스를 복제할 필요가 있을 때?!
- 복잡한 객체 만드는 과정을 숨길 수 있다
- 시간 / 공간적인 리소스를 아낄 수 있다 (메모리에 올라와 있는 놈을 쇽쇽)
- 추상적인 타입 리턴 가능?!
본래 method signature는 Object를 반환하게 만들어져 있으나 공변 반환 지원으로
Object, Cloneable, 해당 객체 타입 반환 오께이다
 */
