package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/20.
 * 看第i个,求i左边最大值MaxLeft,i右边最大值MaxRight,取两者小数,如MaxLeft,求MaxLeft-ai,大于0,则是该i个装水量
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return Integer.MIN_VALUE;
        int len = height.length;
        int result = 0;
        int l = 0, r = len - 1; //左右指针
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l)); //左右指针间的水面积
            if (height[l] < height[r]) { //左指针更小,左指针遍历两指针间比自己小的则更新自己
                int k = l;
                while (k < r && height[k] <= height[l]) k++;
                l = k;
            } else {
                int k = r; //右指针更小,右指针遍历两指针间比自己小的则更新自己
                while (k > l && height[k] <= height[r]) k--;
                r = k;
            }
        }
        return result;
    }

    //not right ?
    public int maxArea2(int[] height) {
        if (height == null || height.length <= 1) return Integer.MIN_VALUE;

        int result = 0;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int l = 1;
        int r = height.length - 2;

        while (l <= r) {
            if (leftMax <= rightMax) {
                result += Math.max(0, leftMax - height[l]);
                leftMax = Math.max(leftMax, height[l++]);
            } else {
                result += Math.max(0, rightMax - height[r]);
                rightMax = Math.max(rightMax, height[r--]);
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
        System.out.println("maxArea = " + new ContainerWithMostWater().maxArea2(h));
    }
}
