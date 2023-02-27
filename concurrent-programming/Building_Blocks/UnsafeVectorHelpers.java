package net.jcip.examples;

import java.util.Vector;

/**
 * UnsafeVectorHelpers
 * <p/>
 * Compound actions on a Vector that may produce confusing results
 *
 * @author Brian Goetz and Tim Peierls
 */
public class UnsafeVectorHelpers {

  public static Object getLast(Vector<?> list) {
    int lastIndex = list.size() - 1;
    return list.get(lastIndex);
  }

  public static void deleteLast(Vector<?> list) {
    int lastIndex = list.size() - 1;
    list.remove(lastIndex);
  }
}

/*
Vector 자체는 스레드 안전하지만 Vector의 메소드를 호출하는 쪽에서 안전성을 박살낼 수 있다
단일 연산이어야 할 메서드를 동기화 걸지 않고 별개로 호출하면 안전성이 깨진다
동기화를 걸 때에도 UnsafeVectorHelpers로 lock 잡지 말고 Vector 자체의 lock 잡아야 한다
 */