package com.agenthun.nowcoder;

import java.util.ArrayList;

/**
 * Created by agenthun on 16/2/6.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) return result;

        //左右指针两头遍历
        int left = 0, right = array.length - 1;
        int mux = Integer.MAX_VALUE;
        while (left < right) {
            int sumTemp = array[left] + array[right];
            if (sumTemp > sum) //和大于目标,右指针移动
                right--;
            else if (sumTemp < sum)//和小于目标,左指针移动
                left++;
            else {
                int temp = array[left] * array[right]; //判断乘积
                if (temp < mux) {
                    result = new ArrayList<>();
                    mux = temp;
                    result.add(array[left]);
                    result.add(array[right]);
                }
                left++;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        int target = 7;
        System.out.println("target = " + target);

        ArrayList<Integer> result = FindNumbersWithSum(a, target);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
