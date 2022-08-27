package org.designpattern.construction.prototype._03_java;

import org.designpattern.construction.prototype._01_before.GithubIssue;
import org.designpattern.construction.prototype._01_before.GithubRepository;
import org.modelmapper.ModelMapper;

public class ModelMapperExample {

	public static void main(String[] args) {
		GithubRepository repository = new GithubRepository();
		repository.setUser("whiteship");
		repository.setName("live-study");

		GithubIssue origin = new GithubIssue(repository);
		origin.setId(1);
		origin.setTitle("1주차 과제: JVM은 무엇이며 자바 코드는 어떻게 실행하는 것인가.");

		ModelMapper modelMapper = new ModelMapper();
		GithubIssueData clone = modelMapper.map(origin, GithubIssueData.class);
		System.out.println(clone);
	}
}

/*
modelmapper는 reflection을 사용해서 값을 복사한다.
 */
