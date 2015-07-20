package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/20.
 */
public class FindMinDistance {
    public static int min(int m, int n) {
        return m > n ? n : m;
    }

    public static int findMinDistance(int[] a, int n1, int n2) {
        if (a == null || a.length <= 1) return Integer.MIN_VALUE;
        int len = a.length;
        int n1Index = -1;
        int n2Index = -1;
        int minDistance = Integer.MIN_VALUE + 1;
        for (int i = 0; i < len; i++) {
            if (a[i] == n1) {
                n1Index = i;
                if (n2Index >= 0) minDistance = min(Math.abs(minDistance), Math.abs(n1Index - n2Index));
            }
            if (a[i] == n2) {
                n2Index = i;
                if (n1Index >= 0) minDistance = min(Math.abs(minDistance), Math.abs(n2Index - n1Index));
            }
        }
        return minDistance;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 4, 7, 4, 6, 4, 7, 8, 5, 6, 4, 3, 10, 8};
        System.out.println("4 and 8 min distance = " + findMinDistance(a, 4, 8));
    }
}
