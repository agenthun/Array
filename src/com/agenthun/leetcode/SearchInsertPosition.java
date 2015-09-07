package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/7.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (nums == null || nums.length < 1) return -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int target = 5;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("target = " + target);
        System.out.println("searchInsert(a, target) = " + new SearchInsertPosition().searchInsert(a, target));

        int[] b = {1, 3, 5, 6};
        int targetB = 7;
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        System.out.println("targetB = " + targetB);
        System.out.println("searchInsert(b, targetB) = " + new SearchInsertPosition().searchInsert(b, targetB));
    }
}
