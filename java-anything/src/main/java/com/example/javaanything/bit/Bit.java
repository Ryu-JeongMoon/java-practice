package com.example.javaanything.bit;

public class Bit {

	public static void main(String[] args) {
		int num1 = 0x00000007;
		int num2 = 0x00000009;

		System.out.println((num1 ^ num2) + ((num1 & num2) << 1));
	}
}

/*
A, B 두 비트의 덧셈은 (A XOR B) + ((A AND B) << 1) 로 계산할 수 있다.
 */