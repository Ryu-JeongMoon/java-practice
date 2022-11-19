package net.jcip.examples;

import net.jcip.annotations.Immutable;

/**
 * Point
 * <p/>
 * Immutable Point class used by DelegatingVehicleTracker
 *
 * @author Brian Goetz and Tim Peierls
 */
@Immutable
public record Point(int x, int y) {

}
