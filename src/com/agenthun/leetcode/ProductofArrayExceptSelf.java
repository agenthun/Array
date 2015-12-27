package com.agenthun.leetcode;

/**
 * Created by agenthun on 15/12/27.
 */
public class ProductofArrayExceptSelf {
    int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[result.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i + 1] * nums[i + 1];
        }

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        int[] b = new ProductofArrayExceptSelf().productExceptSelf(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
