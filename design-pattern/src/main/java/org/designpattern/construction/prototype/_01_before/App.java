package org.designpattern.construction.prototype._01_before;

public class App {

	public static void main(String[] args) {
		GithubRepository repository = new GithubRepository();
		repository.setUser("panda-bear");
		repository.setName("java-practice");

		GithubIssue githubIssue = new GithubIssue(repository);
		githubIssue.setId(1);
		githubIssue.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

		String url = githubIssue.getUrl();
		System.out.println(url);
	}
}
