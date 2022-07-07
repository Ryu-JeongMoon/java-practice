package org.designpattern.construction.singleton;

import java.io.Serial;
import java.io.Serializable;

public class Settings implements Serializable {

  private static volatile Settings instance;

  private Settings() {
  }

  public static Settings getInstance() {
    if (instance == null) {
      instance = new Settings();
    }

    return instance;
  }

  public static Settings getInstanceWithDCL() {
    if (instance == null) {
      synchronized (Settings.class) {
        if (instance == null) {
          instance = new Settings();
        }
      }
    }
    return instance;
  }

  private static class LazyHolder {

    private static final Settings INSTANCE = new Settings();
  }

  public static Settings getInstanceWithLazyHolder() {
    return LazyHolder.INSTANCE;
  }

  @Serial
  protected Object readResolve() {
    return getInstance();
  }
}

/*
protected Object readResolve() {}
signature 완존히 동일해야 함
반환 타입을 Settings로 해두면 얘를 호출하지 않음둥
제대로 썼으면 최신 버전의 자바에서는 @Serial 붙이라고 알려줌
 */