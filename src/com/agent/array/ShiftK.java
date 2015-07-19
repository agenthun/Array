package com.agent.array;

/**
 * Created by Agent Henry on 2015/7/17.
 */
public class ShiftK {
    public static void reverse(int[] a, int b, int e) {
        for (; b < e; b++, e--) {
            int temp = a[e];
            a[e] = a[b];
            a[b] = temp;
        }
    }

    public static void shiftK(int[] a, int k) {
        int len = a.length;
        k = k % len; //防止k比a长度大
        reverse(a, 0, len - k - 1);
        reverse(a, len - k, len - 1);
        reverse(a, 0, len - 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        shiftK(a, 2);
        System.out.println("\r\n向右循环移2位");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
