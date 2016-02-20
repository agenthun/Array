package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/21.
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 3, 4, 4, 5, 5, 5, 6};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int k = 4;
        System.out.println("k = " + k);

        System.out.println("GetNumberOfK(a,k) = " + new GetNumberOfK().GetNumberOfK(a, k));
    }
}
