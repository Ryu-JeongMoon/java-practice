package org.eternity.billing.step02;

import java.time.Duration;
import java.time.LocalDateTime;

public record Call(LocalDateTime from, LocalDateTime to) {

	public Duration getDuration() {
		return Duration.between(from, to);
	}
}
