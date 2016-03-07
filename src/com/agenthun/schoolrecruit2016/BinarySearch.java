package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/7.
 * 对于一个有序数组，我们通常采用二分查找的方式来定位某一元素，请编写二分查找的算法，在数组中查找指定元素。
 * 给定一个整数数组A及它的大小n，同时给定要查找的元素val，请返回它在数组中的位置(从0开始)，若不存在该元素，返回-1。若该元素出现多次，请返回第一次出现的位置。
 * 测试样例：[1,3,5,7,9],5,3
 * 返回：1
 */
public class BinarySearch {
    public int getPos(int[] A, int n, int val) {
        // write code here
        if (A == null || A.length == 0) return -1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (A[mid] < val) {
                left = mid + 1;
            } else if (A[mid] > val) {
                right = mid - 1;
            } else {
                while (mid >= 1 && A[mid - 1] == val) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 4, 10, 21};
        int n = 4;
        int val = 4;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("n = " + n);
        System.out.println("val = " + val);

        System.out.println("getPos(a,n,val) = " + new BinarySearch().getPos(a, n, val));
    }
}
