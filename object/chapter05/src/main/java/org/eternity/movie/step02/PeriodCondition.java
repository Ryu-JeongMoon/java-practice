package org.eternity.movie.step02;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {

	public boolean isSatisfiedBy(Screening screening) {
		return dayOfWeek.equals(screening.whenScreened().getDayOfWeek())
			&& !startTime.isAfter(screening.whenScreened().toLocalTime())
			&& !endTime.isBefore(screening.whenScreened().toLocalTime());
	}
}
