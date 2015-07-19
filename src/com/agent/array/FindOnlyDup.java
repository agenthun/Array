package com.agent.array;

public class FindOnlyDup {
	public static int findOnlyDup(int[] a) {
		int temp1 = 0;
		int temp2 = 0;
		for (int i = 0; i < a.length - 1; i++) {
			temp1 += i + 1;
			temp2 += a[i];
		}
		temp2 += a[a.length - 1];
		return (temp2 - temp1);
	}

	public static int findDup(int[] a) {
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				a[a[i]] = -a[a[i]];
			} else {
				a[-a[i]] = -a[-a[i]];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				result = i;
			} else {
				a[i] = -a[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a1 = { 1, 2, 1, 3, 4 };
		System.out.println("only dup : " + findOnlyDup(a1));

		int[] a2 = { 4, 2, 1, 3, 4 };
		System.out.println("dup : " + findDup(a2));
	}
}
