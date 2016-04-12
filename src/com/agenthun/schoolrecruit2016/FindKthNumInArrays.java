package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/11.
 * 给定两个有序数组arr1和arr2，在给定一个整数k，返回两个数组的所有数中第K小的数。
 * 例如：
 * arr1 = {1,2,3,4,5};
 * arr2 = {3,4,5};
 * K = 1;
 * 因为1为所有数中最小的，所以返回1；
 * arr1 = {1,2,3};
 * arr2 = {3,4,5,6};
 * K = 4;
 * 因为3为所有数中第4小的数，所以返回3；
 * 要求：如果arr1的长度为N，arr2的长度为M，时间复杂度请达到O(log(min{M,N}))。
 */
public class FindKthNumInArrays {
    public int findKthNum(int[] arr1, int[] arr2, int kth) {
        int indexA = 0, indexB = 0;
        boolean isA = true;
        for (int i = 0; i < kth; i++) {
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
            if (arr1[indexA] < arr2[indexB]) {
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
        int[] a1 = {1, 2, 3};
        int[] a2 = {3, 4, 5, 6};
        int k = 4;
        System.out.println("findKthNum(a1,a2,k) = " + new FindKthNumInArrays().findKthNum(a1, a2, k));
    }
}
