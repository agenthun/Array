package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/22.
 */
public class IsContinuous {
    public static Boolean isContinuous(int[] a) {
        int len = a.length;
        int min = -1, max = -1;
        for (int i = 0; i < len; i++) {
            if (a[i] != 0) {
                if (min > a[i] || min == -1) min = a[i];
                if (max < a[i] || max == -1) max = a[i];
            }
        }
        if (max - min > len - 1) return false;
        else return true;
    }

    public static void main(String[] args) {
        int[] a = {8, 7, 5, 0, 6};
        if (isContinuous(a)) System.out.println("数组中数值连续相邻");
        else System.out.println("数组中数值不连续相邻");
    }
}
