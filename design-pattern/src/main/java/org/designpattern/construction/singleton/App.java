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
    // breakSingletonByReflection(settings, lazySettings);
    breakSingletonByDeserialization(settings);
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
