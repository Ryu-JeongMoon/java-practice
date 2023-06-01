package net.jcip.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import net.jcip.annotations.ThreadSafe;

/**
 * DelegatingVehicleTracker
 * <p/>
 * Delegating thread safety to a ConcurrentHashMap
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class DelegatingVehicleTracker {

  private final ConcurrentMap<String, Point> locations;
  private final Map<String, Point> unmodifiableMap;

  public DelegatingVehicleTracker(Map<String, Point> points) {
    locations = new ConcurrentHashMap<>(points);
    unmodifiableMap = Collections.unmodifiableMap(locations);
  }

  // 실시간 정보 반환 방식, 다른 스레드에 의한 변경도 이미 조회된 데이터에 반영이 됨
  // 복사본이 아니라 원본 자체를 넘겼기 때문, 어차피 Point 객체는 불변이라 안전하나
  // Map 내부 자료를 바꿔낄 수 있으므로 Point1 -> Point2 로 변경되는 것은 막지 못함
  public static void main(String[] args) throws InterruptedException {
    Map<String, Point> points = Map.of("1", new Point(1, 2), "2", new Point(3, 4));
    DelegatingVehicleTracker tracker = new DelegatingVehicleTracker(points);

    Map<String, Point> locations = tracker.getLocations();
    Map<String, Point> locationsAsStatic = tracker.getLocationsAsStatic();
    System.out.println(locations);
    System.out.println(locationsAsStatic);

    Thread thread = new Thread(() -> tracker.setLocation("1", 5, 6));
    thread.start();

    Thread.sleep(50);
    System.out.println(locations);          // [5,6] [3,4]
    System.out.println(locationsAsStatic);  // [1,2] [3,4]
  }

  // A 스레드가 위치 정보를 가져간 후
  // B 스레드가 위치 정보를 변경시켰다면
  // 이미 A 스레드가 가져간 위치 정보도 변경이 되버린다
  public Map<String, Point> getLocations() {
    return unmodifiableMap;
  }

  public Point getLocation(String id) {
    return locations.get(id);
  }

  public void setLocation(String id, int x, int y) {
    if (locations.replace(id, new Point(x, y)) == null) {
      throw new IllegalArgumentException("invalid vehicle name: " + id);
    }
  }

  // Alternate version of getLocations (Listing 4.8)
  public Map<String, Point> getLocationsAsStatic() {
    return Collections.unmodifiableMap(new HashMap<>(locations));
  }
}
