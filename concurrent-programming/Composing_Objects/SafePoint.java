package net.jcip.examples;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * SafePoint
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class SafePoint {

  @GuardedBy("this")
  private int x, y;

  private SafePoint(int[] a) {
    this(a[0], a[1]);
  }

  public SafePoint(SafePoint p) {
    this(p.get());
  }

  public SafePoint(int x, int y) {
    this.set(x, y);
  }

  // x, y를 개별적으로 가져가게 된다면
  // 그 사이에 값이 바뀌어 안전성이 깨질 수 있으므로 배열로 묶어서 반환
  public synchronized int[] get() {
    return new int[]{ x, y };
  }

  public synchronized void set(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
