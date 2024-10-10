package com.example.javaanything.recursion

class Main {
}

fun main() {
  println(factorial(10))
}

tailrec fun factorial(n: Int, acc: Long = 1): Long {
  return if (n <= 1) acc
  else factorial(n - 1, acc * n)
}
