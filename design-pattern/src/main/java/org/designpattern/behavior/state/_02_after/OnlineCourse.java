package org.designpattern.behavior.state._02_after;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

public class OnlineCourse {

	@ToString.Include
	private final List<String> reviews = new ArrayList<>();
	private final List<Student> students = new ArrayList<>();
	private State state = new Draft(this);

	public void addStudent(Student student) {
		state.addStudent(student);
	}

	public void addReview(String review, Student student) {
		state.addReview(review, student);
	}

	public State getState() {
		return state;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void changeState(State state) {
		this.state = state;
	}
}
