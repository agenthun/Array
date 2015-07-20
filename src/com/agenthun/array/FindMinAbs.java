package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/20.
 */
public class FindMinAbs {
    public static int findMinAbs(int[] a) {
        if (a == null || a.length < 1) return Integer.MIN_VALUE;
        int len = a.length;
        if (a[0] >= 0) return a[0];
        if (a[len - 1] < 0) return a[len - 1];

        int mid = 0;
        int begin = 0;
        int end = len - 1;
        int absMin = 0;
        while (true) {
            mid = begin + (end - begin) / 2;
            if (a[mid] == 0) return 0;
            else if (a[mid] > 0) {
                if (a[mid - 1] > 0) end = mid - 1;
                else if (a[mid - 1] == 0) return 0;
                else break;
            } else {
                if (a[mid + 1] < 0) begin = mid + 1;
                else if (a[mid + 1] == 0) return 0;
                else break;
            }
        }
        if (a[mid] > 0) {
            if (a[mid] < Math.abs(a[mid - 1])) absMin = a[mid];
            else absMin = a[mid - 1];
        } else {
            if (Math.abs(a[mid]) < a[mid + 1]) absMin = a[mid];
            else absMin = a[mid + 1];
        }
        return absMin;
    }

    public static void main(String[] args) {
        int[] a1 = {-10, -5, -2, 7, 15, 20};
        int[] a2 = {2, 4, 6, 8, 27};
        int[] a3 = {-10, -5, -2, -1};
        System.out.println("a1 min abs = " + findMinAbs(a1));
        System.out.println("a2 min abs = " + findMinAbs(a2));
        System.out.println("a3 min abs = " + findMinAbs(a3));
    }
}
