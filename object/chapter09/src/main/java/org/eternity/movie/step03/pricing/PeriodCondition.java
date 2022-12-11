package org.eternity.movie.step03.pricing;

import java.time.DayOfWeek;
import java.time.LocalTime;

import org.eternity.movie.step03.DiscountCondition;
import org.eternity.movie.step03.Screening;

public record PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) implements DiscountCondition {

	public boolean isSatisfiedBy(Screening screening) {
		return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
			&& !startTime.isAfter(screening.getStartTime().toLocalTime())
			&& !endTime.isBefore(screening.getStartTime().toLocalTime());
	}
}
