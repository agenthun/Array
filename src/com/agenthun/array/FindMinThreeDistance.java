package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/23.
 */
public class FindMinThreeDistance {
    public static int min(int a, int b, int c) {
        int min = a < b ? a : b;
        min = min < c ? min : c;
        return min;
    }

    public static int max(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }


    public static int findMinThreeDistance(int[] a, int[] b, int[] c) {
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;
        int curDist = 0;
        int min = 0;
        int minDist = Integer.MAX_VALUE;
        int i = 0, j = 0, k = 0;

        while (true) {
            curDist = max(Math.abs(a[i] - b[j]), Math.abs(b[j] - c[k]), Math.abs(a[i] - c[k]));
            if (curDist < minDist) minDist = curDist;
            min = min(a[i], b[j], c[k]);
            if (min == a[i]) {
                if (++i >= aLen) break;
            } else if (min == b[j]) {
                if (++j >= bLen) break;
            } else {
                if (++k >= cLen) break;
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 4, 5, 7};
        int[] a2 = {10, 12, 14, 16, 17};
        int[] a3 = {20, 21, 23, 24, 27, 30};
        System.out.println("min three distance = " + findMinThreeDistance(a1, a2, a3));
    }
}
