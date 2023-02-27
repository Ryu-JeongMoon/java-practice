package net.jcip.examples;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * MonitorVehicleTracker
 * <p/>
 * Monitor-based vehicle tracker implementation
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public record MonitorVehicleTracker(
		@GuardedBy("this") Map<String, MutablePoint> locations
) {

	public MonitorVehicleTracker(Map<String, MutablePoint> locations) {
		this.locations = deepCopy(locations);
	}

	private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> m) {
		Map<String, MutablePoint> result = new HashMap<>();

		for (String id : m.keySet()) {
			result.put(id, new MutablePoint(m.get(id)));
		}

		return Collections.unmodifiableMap(result);
	}

	// 요청하는 순간, 락이 걸린 후 복사본을 만들기 때문에 요청 시점의 고정된 값들이 반환된다
	// 실시간으로 변경되는 것을 반영하려는 요구사항에는 맞지 않은 방식
	@Override
	public synchronized Map<String, MutablePoint> locations() {
		return deepCopy(locations);
	}

	public synchronized MutablePoint getLocation(String id) {
		MutablePoint loc = locations.get(id);
		return loc == null
				? null
				: new MutablePoint(loc);
	}

	public synchronized void setLocation(String id, int x, int y) {
		MutablePoint loc = locations.get(id);
		if (loc == null) {
			throw new IllegalArgumentException("No such ID: " + id);
		}

		loc.x = x;
		loc.y = y;
	}
}
