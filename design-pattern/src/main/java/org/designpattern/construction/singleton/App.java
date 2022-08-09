package org.designpattern.construction.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class App {

  public static void main(String[] args) throws Exception {
    Settings settings = Settings.getInstance();
    Settings lazySettings = Settings.getInstanceWithLazyHolder();

    // compareByNormalSingleton(settings, lazySettings);
    breakSingletonByReflection(settings, lazySettings);
    // breakSingletonByDeserialization(settings);
  }

  private static void compareByNormalSingleton(Settings settings, Settings lazySettings) {
    // System.out.println("(settings == another settings) = " + (settings == Settings.getInstance()));
    System.out.println("(settings == Settings.getInstanceWithDCL()) = " + (settings == Settings.getInstanceWithDCL()));
    System.out.println("(lazy settings == Settings.getInstanceWithLazyHolder()) = " + (lazySettings == Settings.getInstanceWithLazyHolder()));
  }

  // reflection 사용해 깨부수기
  private static void breakSingletonByReflection(Settings settings, Settings lazySettings) throws Exception {
    Constructor<Settings> constructor = Settings.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    Settings settingsByReflection = constructor.newInstance();

    System.out.println("(settings == settingsByReflection) = " + (settings == settingsByReflection));
    System.out.println("(lazySettings == settingsByReflection) = " + (lazySettings == settingsByReflection));
  }

  // deserializable 사용해 깨부수기
  private static void breakSingletonByDeserialization(Settings settings) throws IOException, ClassNotFoundException {
    try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
      out.writeObject(settings);
    }

    Settings settingsByDeserialization = null;
    try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
      settingsByDeserialization = (Settings) in.readObject();
    }
    System.out.println("(settings == settingsByDeserialization) = " + (settings == settingsByDeserialization));
  }
}

/*
LazyHolder 쓰는 것이 개념적으로는 맞지만 Reflection에 의해 깨질 수 있다
Enum은 생성할 때 Reflection을 막는 코드가 작성되어 있기 때문에 안전하당
1. Enum 사용의 단점은 클래스를 사용하려 할 때, 인스턴스가 생성된다는 점 (Lazy Loading이 안 됨)
2. 암묵적으로 extends Enum<T>가 되기 때문에 상속을 사용할 수 없다는 점이 있다

상속을 사용하지 못하도록 하는 것은 어찌보면 Best-Practice로 활용할 수도 있슴둥
강제적으로 Interface-based Programming을 유도하므로
 */