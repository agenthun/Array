package com.agenthun.array;

public class FindNotDouble {
	public static int findNotDouble(int[] a) {
		int result = a[0];
		for (int i = 1; i < a.length; i++) {
			result ^= a[i];
		}
		return result;
	}

	public static int findOnce(int[] a, int appearTimes) {
		int[] bitCount = new int[32];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < bitCount.length; j++) {
				bitCount[j] += ((a[i] >> j) & 1);
			}
		}
		int appearOne = 0;
		for (int i = 0; i < bitCount.length; i++) {
			if (bitCount[i] % appearTimes != 0) {
				appearOne += (1 << i);
			}
		}
		return appearOne;
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 3, 2, 4, 3, 5, 4, 1 };
		System.out.println("not double : " + findNotDouble(a1));

		int[] a2 = { 1, 2, 1, 2, 4, 2, 4, 4, 1, 3 };
		System.out.println("only once : " + findOnce(a2, 3));
	}
}
