package com.example.javaanything.recursion;

import java.util.Arrays;

public class Recursion {

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    System.out.println(sumRecursively(array));
    System.out.println(sumTailRecursively(array));
    System.out.println(sumIteratively(array));
    System.out.println(sumEnhancedIteratively(array));
  }

  private static int sumRecursively(int[] array) {
    return sumRecursivelyInternal(array, 0);
  }

  private static int sumRecursivelyInternal(int[] array, int index) {
    if (index == array.length) {
      return 0;
    } else {
      return sumRecursivelyInternal(array, index + 1) + array[index];
    }
  }

  // JVM doesn't optimize tail recursion, so this is not better than the above
  private static int sumTailRecursively(int[] array) {
    return sumTailRecursivelyInternal(array, 0, 0);
  }

  private static int sumTailRecursivelyInternal(int[] array, int index, int sum) {
    if (index == array.length) {
      return sum;
    } else {
      return sumTailRecursivelyInternal(array, index + 1, sum + array[index]);
    }
  }

  private static int sumIteratively(int[] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }
    return sum;
  }

  private static int sumEnhancedIteratively(int[] array) {
    return Arrays.stream(array).sum();
  }
}
