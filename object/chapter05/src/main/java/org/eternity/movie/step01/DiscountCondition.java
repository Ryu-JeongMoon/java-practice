package org.eternity.movie.step01;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DiscountCondition(DiscountConditionType type, int sequence, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {

	public boolean isSatisfiedBy(Screening screening) {
		if (type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod(screening);
		}

		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedByPeriod(Screening screening) {
		return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek())
			&& !startTime.isAfter(screening.getWhenScreened().toLocalTime())
			&& !endTime.isAfter(screening.getWhenScreened().toLocalTime());
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return sequence == screening.getSequence();
	}
}
