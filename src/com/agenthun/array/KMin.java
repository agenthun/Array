package com.agenthun.array;

/**
 * Created by Agent Henry on 2015/7/17.
 */
public class KMin {

    //第k个从1开始算
    public static int QuickSort(int[] a, int l, int r, int indexK) {
        if (l > r) return Integer.MIN_VALUE;
        int i = l + 1;
        int j = r;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] < x) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = x;
        if (i + 1 == indexK)
            return x;
        else if (i + 1 > indexK)
            return QuickSort(a, l, i - 1, indexK);
        else
            return QuickSort(a, i + 1, r, indexK);
    }

    private static int findKMin(int[] a, int k) {
        if (a == null || a.length < k) return Integer.MIN_VALUE;
        return QuickSort(a, 0, a.length - 1, k);
    }

    private static int findKMin2(int[] a, int k) {
        if (a == null || a.length < k) return Integer.MIN_VALUE;
        return QuickSort2(a, 0, a.length - 1, k);
    }

    //第k个从0开始算
    private static int QuickSort2(int[] a, int left, int right, int k) {
        int i = left;
        int j = right;
        int temp = a[i];
        while (i < j) {
            while (i < j && a[j] >= temp) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] < temp) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = temp;
        if (i == k)
            return temp;
        else if (i < k) {
            return QuickSort2(a, i + 1, left, k);
        } else { //注意这里不是if else
            return QuickSort2(a, right, i - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 8, 0, 6};
        int kMin = findKMin(a, 4);
        System.out.println("kMin = " + kMin);
        System.out.println("kMin = " + findKMin2(a, 4 - 1));
    }
}
