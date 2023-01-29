package org.designpattern.behavior.state._02_after;

public record Published(OnlineCourse onlineCourse) implements State {

	@Override
	public void addReview(String review, Student student) {
		this.onlineCourse.getReviews().add(review);
	}

	@Override
	public void addStudent(Student student) {
		this.onlineCourse.getStudents().add(student);
	}
}
