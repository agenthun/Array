package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/6.
 */
public class MergeTwoSortedArrays {
    int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] result = new int[aLen + bLen];
        while (bLen > 0 || aLen > 0) {
            if (aLen <= 0 || (bLen > 0 && a[aLen - 1] < b[bLen - 1])) {
                result[aLen + bLen - 1] = b[--bLen];
            } else {
                result[aLen + bLen - 1] = a[--aLen];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 3, 5, 7, 9, 13, 14, 15, 16, 17};
        int[] b = {2, 4, 6, 8, 10, 11, 12};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        int[] result = (new MergeTwoSortedArrays()).mergeTwoSortedArrays(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}