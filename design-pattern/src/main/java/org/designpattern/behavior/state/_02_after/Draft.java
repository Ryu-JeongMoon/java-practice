package org.designpattern.behavior.state._02_after;

public record Draft(OnlineCourse onlineCourse) implements State {

	@Override
	public void addReview(String review, Student student) {
		throw new UnsupportedOperationException("드래프트 상태에서는 리뷰를 남길 수 없습니다.");
	}

	@Override
	public void addStudent(Student student) {
		this.onlineCourse.getStudents().add(student);
		if (this.onlineCourse.getStudents().size() > 1) {
			this.onlineCourse.changeState(new Private(this.onlineCourse));
		}
	}
}
