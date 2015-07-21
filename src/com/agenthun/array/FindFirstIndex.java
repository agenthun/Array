package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/21.
 */
public class FindFirstIndex {
    public static int findFirstIndex(int[] a, int t) {
        if (a == null) return -1;
        int len = a.length;
        int i = 0;
        while (i < len) {
            if (a[i] == t) return i;
            else i += Math.abs(t - a[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 5, 6, 7, 8, 9, 8};
        System.out.println("9 fist index = " + findFirstIndex(a, 9));
    }
}
