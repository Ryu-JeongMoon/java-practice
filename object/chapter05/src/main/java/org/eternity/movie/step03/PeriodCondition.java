package org.eternity.movie.step03;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return dayOfWeek.equals(screening.whenScreened().getDayOfWeek())
			&& !startTime.isAfter(screening.whenScreened().toLocalTime())
			&& !endTime.isBefore(screening.whenScreened().toLocalTime());
	}
}
