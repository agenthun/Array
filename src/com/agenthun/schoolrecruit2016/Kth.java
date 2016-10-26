package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/3/22.
 * 利用快排找出第K个最小数, k从0开始
 * 输入数据:
 * 1 0 #数据样本1(个数n,第k个数)
 * 100
 * 5 2 #数据样本2(个数n,第k个数)
 * 2
 * 10
 * 93
 * 41
 * 32
 * 0 0 #样本结束
 * 输出数据
 * 100
 * 32
 */
public class Kth {
    public static int qsort_once(int[] a, int l, int r, int indexK) {
        if (l > r) return -1;
        int i = l;
        int j = r;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] <= x) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = x;
        if (i + 1 == indexK) //注意是比较k与i+1的值
            return x;
        else if (i + 1 > indexK) //k < i+1, 则在前半部份
            return qsort_once(a, l, i - 1, indexK);
        else ////k > i+1, 则在后半部份
            return qsort_once(a, i + 1, r, indexK);
    }

    private static int kth(int[] a, int k) {
        if (a == null || a.length < k) return Integer.MIN_VALUE;
        return qsort_once(a, 0, a.length - 1, k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (n == 0 && k == 0) break;

            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int arrayKth = kth(array, k + 1);
            System.out.println(arrayKth);
        }
    }
}
