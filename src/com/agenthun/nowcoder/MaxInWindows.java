package com.agenthun.nowcoder;

import java.util.ArrayList;

/**
 * Created by agenthun on 16/3/4.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0 || size > num.length) return result;
        if (size == num.length) { //数组长度为窗口大小,则找最大数
            int max = num[0];
            for (int i = 1; i < num.length; i++) {
                if (max < num[i]) max = num[i];
            }
            result.add(max);
            return result;
        }

        //无技巧,一个指针偏移,在偏移内求最大值
        for (int i = 0; (i + size - 1) < num.length; i++) {
            int max = num[i];
            for (int j = i + 1; j < (i + size); j++) {
                if (max < num[j]) max = num[j];
            }
            result.add(max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int k = 9;
        System.out.println("k = " + k);

        ArrayList<Integer> result = new MaxInWindows().maxInWindows(a, k);
        for (Integer x :
                result) {
            System.out.print(x + " ");
        }
    }
}
