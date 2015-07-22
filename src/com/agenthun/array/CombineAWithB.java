package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/22.
 */
public class CombineAWithB {
    public static void findRightPlaceForMid(int[] a, int mid) {
        for (int i = mid; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                int temp = a[i];
                a[i] = a[i + 1];
                a[i + 1] = temp;
            }
        }
    }

    public static void combineAWithB(int[] a, int mid) {
        for (int i = 0; i < mid; i++) {
            if (a[mid] < a[i]) {
                int temp = a[mid];
                a[mid] = a[i];
                a[i] = temp;
                findRightPlaceForMid(a, mid);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 6, 7, 9, 2, 4, 8, 10, 13, 14};
        System.out.println("old array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        combineAWithB(a, 5);
        System.out.println("\r\nnew array");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
