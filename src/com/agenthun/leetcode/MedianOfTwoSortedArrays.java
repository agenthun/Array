package com.agenthun.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Agent Henry on 2015/8/16.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if ((len & 1) == 1) {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2);
        } else {
            return (findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2 - 1) + findKth(nums1, 0, m - 1, nums2, 0, n - 1, len / 2)) / 2.0;
        }
    }

    private double findKth(int[] nums1, int begin1, int end1, int[] nums2, int begin2, int end2, int k) {
        int len1 = end1 - begin1 + 1;
        int len2 = end2 - begin2 + 1;

        if (len1 == 0) return nums2[begin2 + k];
        if (len2 == 0) return nums1[begin1 + k];
        if (k == 0) return nums1[begin1] < nums2[begin2] ? nums1[begin1] : nums2[begin2];

        int mid1 = len1 * k / (len1 + len2);
        int mid2 = k - mid1 - 1;
        mid1 += begin1;
        mid2 += begin2;
        if (nums1[mid1] > nums2[mid2]) {
            k -= mid2 - begin2 + 1;
            end1 = mid1;
            begin2 = mid2 + 1;
        } else {
            k -= mid1 - begin1 + 1;
            end2 = mid2;
            begin1 = mid1 + 1;
        }
        return findKth(nums1, begin1, end1, nums2, begin2, end2, k);
    }


    public static void main(String[] args) {
        int[] a1 = {1, 3, 5, 7, 9};
        int[] a2 = {2, 4, 6, 8};
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i] + " ");
        }
        System.out.println();
        System.out.println("Median = " + new MedianOfTwoSortedArrays().findMedianSortedArrays(a1, a2));
    }
}
