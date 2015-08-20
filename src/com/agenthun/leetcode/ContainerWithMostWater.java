package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/20.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return Integer.MIN_VALUE;
        int len = height.length;
        int result = 0;
        int l = 0, r = len - 1;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                int k = l;
                while (k < r && height[k] <= height[l]) k++;
                l = k;
            } else {
                int k = r;
                while (k > l && height[k] <= height[r]) k--;
                r = k;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] h = {1, 3, 5, 7, 9};
        for (int i = 0; i < h.length; i++) {
            System.out.print(h[i] + " ");
        }
        System.out.println();
        System.out.println("maxArea = " + new ContainerWithMostWater().maxArea(h));
    }
}
