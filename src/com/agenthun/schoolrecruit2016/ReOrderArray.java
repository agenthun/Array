package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 2016/9/26.
 * 调整数组顺序使奇数位于偶数前面,保持相反的稳定性
 * 时间O(n)，空间O(n)
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 3, 8, 2, 2, 9, 10};
        int[] temp = new int[a.length]; //用空间换时间
        int index = a.length - 1;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 0x01) == 0) {
                temp[index--] = a[i];
            }
        }

        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 0x01) == 1) {
                temp[index--] = a[i];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
    }
}
