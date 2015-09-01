package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/1.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n = " + n);
        int[] a = {1, 3, 5, 2, 8, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("removeElement(a, n) = " + new RemoveElement().removeElement(a, n));
    }
}
