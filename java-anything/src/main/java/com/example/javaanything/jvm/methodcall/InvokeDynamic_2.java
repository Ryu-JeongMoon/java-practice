package com.example.javaanything.jvm.methodcall;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class InvokeDynamic_2 {

  static class Son extends InvokeDynamic.Father {

    @Override
    void thinking() {
      try {
        MethodType mt = MethodType.methodType(void.class);
        Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
        lookupImpl.setAccessible(true);
        ((MethodHandles.Lookup) lookupImpl.get(null))
          .findSpecial(InvokeDynamic.GrandFather.class, "thinking", mt, InvokeDynamic.GrandFather.class)
          .invoke(this);
      } catch (Throwable e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void main(String[] args) {
    InvokeDynamic.GrandFather grandFather = new InvokeDynamic.GrandFather();
    grandFather.thinking();

    InvokeDynamic.Father father = new InvokeDynamic.Father();
    father.thinking();

    Son son = new Son();
    son.thinking();
  }
}

/*
JDK16 이상에서는 아래와 같은 에러가 발생

Exception in thread "main" java.lang.RuntimeException: java.lang.reflect.InaccessibleObjectException: Unable to make field static final java.lang.invoke.MethodHandles$Lookup java.lang.invoke.MethodHandles$Lookup.IMPL_LOOKUP accessible: module java.base does not "opens java.lang.invoke" to unnamed module @65b3120a
	at com.example.javaanything.jvm.methodcall.InvokeDynamic_2$Son.thinking(InvokeDynamic_2.java:21)
	at com.example.javaanything.jvm.methodcall.InvokeDynamic_2.main(InvokeDynamic_2.java:34)
Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make field static final java.lang.invoke.MethodHandles$Lookup java.lang.invoke.MethodHandles$Lookup.IMPL_LOOKUP accessible: module java.base does not "opens java.lang.invoke" to unnamed module @65b3120a
	at java.base/java.lang.reflect.AccessibleObject.throwInaccessibleObjectException(AccessibleObject.java:391)
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:367)
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:315)
	at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:183)
	at java.base/java.lang.reflect.Field.setAccessible(Field.java:177)
	at com.example.javaanything.jvm.methodcall.InvokeDynamic_2$Son.thinking(InvokeDynamic_2.java:16)
	... 1 more
*/
