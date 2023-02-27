package net.jcip.examples;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * CooperatingNoDeadlock
 * <p/>
 * Using open calls to avoiding deadlock between cooperating objects
 *
 * @author Brian Goetz and Tim Peierls
 */
class CooperatingNoDeadlock {

	static class Image {

		public void drawMarker(Point p) {
		}
	}

	@ThreadSafe
	class Taxi {

		private final Dispatcher dispatcher;

		@GuardedBy("this")
		private Point location, destination;

		public Taxi(Dispatcher dispatcher) {
			this.dispatcher = dispatcher;
		}

		public synchronized Point getLocation() {
			return location;
		}

		public synchronized void setLocation(Point location) {
			boolean reachedDestination;
			synchronized (this) {
				this.location = location;
				reachedDestination = location.equals(destination);
			}

			if (reachedDestination) {
				dispatcher.notifyAvailable(this);
			}
		}

		public synchronized Point getDestination() {
			return destination;
		}

		public synchronized void setDestination(Point destination) {
			this.destination = destination;
		}
	}

	@ThreadSafe
	class Dispatcher {

		@GuardedBy("this")
		private final Set<Taxi> taxis;

		@GuardedBy("this")
		private final Set<Taxi> availableTaxis;

		public Dispatcher() {
			taxis = new HashSet<>();
			availableTaxis = new HashSet<>();
		}

		public synchronized void notifyAvailable(Taxi taxi) {
			availableTaxis.add(taxi);
		}

		public Image getImage() {
			Set<Taxi> copy;
			synchronized (this) {
				copy = new HashSet<>(taxis);
			}

			Image image = new Image();
			for (Taxi t : copy) {
				image.drawMarker(t.getLocation());
			}

			return image;
		}
	}
}