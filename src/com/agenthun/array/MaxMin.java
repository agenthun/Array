package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/13.
 */
public class MaxMin {
    static int Max;
    static int Min;

    public static void GetMaxAndMin(int a[]) {
        Max = a[0];
        Min = a[0];
        int len = a.length;
        for (int i = 1; i < len - 1; i = i + 2) {
            if (i + 1 > len) {
                if (a[i] > Max) Max = a[i];
                if (a[i] < Min) Min = a[i];
            }
            if (a[i] > a[i + 1]) {
                if (a[i] > Max) Max = a[i];
                if (a[i + 1] < Min) Min = a[i + 1];
            }
            if (a[i] < a[i + 1]) {
                if (a[i] < Min) Min = a[i];
                if (a[i + 1] > Max) Max = a[i + 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 3, 19, 40, 4, 7, 1};
        GetMaxAndMin(a);
        System.out.println("max = " + Max);
        System.out.println("min = " + Min);
    }
}
