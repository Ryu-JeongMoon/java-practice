package org.eternity.movie.step05;

import java.time.LocalDateTime;

public record Screening(Movie movie, int sequence, LocalDateTime whenScreened) {

}
