package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/18.
 * 给定两个有序数组arr1和arr2，两个数组长度都为N，求两个数组中所有数的上中位数。
 * 例如：
 * arr1 = {1,2,3,4};
 * arr2 = {3,4,5,6};
 * 一共8个数则上中位数是第4个数，所以返回3。
 * arr1 = {0,1,2};
 * arr2 = {3,4,5};
 * 一共6个数则上中位数是第3个数，所以返回2。
 * 要求：时间复杂度O(logN)
 */
public class GetUpMedian {
    public int getUpMedian(int[] arr1, int[] arr2) {
        boolean isA = true;
        int indexA = 0, indexB = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (indexA == arr1.length) {
                indexB++;
                isA = false;
                continue;
            }
            if (indexB == arr2.length) {
                indexA++;
                isA = true;
                continue;
            }
            if (arr1[indexA] <= arr2[indexB]) {
                indexA++;
                isA = true;
            } else {
                indexB++;
                isA = false;
            }
        }
        return isA ? arr1[indexA - 1] : arr2[indexB - 1];
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2};//{1, 2, 3, 4};
        int[] arr2 = {3, 4, 5};//{3, 4, 5, 6};
        System.out.println("getUpMedian(arr1,arr2) = " + new GetUpMedian().getUpMedian(arr1, arr2));
    }
}
