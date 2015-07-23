package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/23.
 */
public class FindReverseCount {
    public static int reverseCount = 0;

    public static void merge(int[] a, int begin, int mid, int end) {
        int i, j, k, n1, n2;
        n1 = mid - begin + 1;
        n2 = end - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        for (i = 0, k = begin; i < n1; i++, k++) {
            l[i] = a[k];
        }
        for (i = 0, k = mid + 1; i < n2; i++, k++) {
            r[i] = a[k];
        }
        for (k = begin, i = 0, j = 0; i < n1 && j < n2; k++) {
            if (l[i] < r[j]) a[k] = l[i++];
            else {
                reverseCount += mid - i + 1;
                a[k] = r[j++];
            }
        }
        if (i < n1) {
            for (j = i; j < n1; j++, k++) {
                a[k] = l[j];
            }
        }
        if (j < n2) {
            for (i = j; i < n2; i++, k++) {
                a[k] = r[i];
            }
        }
    }

    public static void mergeSort(int[] a, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(a, begin, mid);
            mergeSort(a, mid + 1, end);
            merge(a, begin, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 3, 2, 6};
        mergeSort(a, 0, a.length - 1);
        System.out.println("a reverse count = " + reverseCount);
    }
}
