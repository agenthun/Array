package com.agenthun.schoolrecruit2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by agenthun on 16/9/18.
 * 无序数组中找出符合 a + b = c + d 的对数
 */
public class FourSumII {
    private static int findSum(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length - 3; i++) {
            for (int j = a.length - 1; j > i + 2; j--) {
                int left = i + 1;
                int right = j - 1;
                int sum = i + j;
                while (left < right) {
                    if (a[left] + a[right] < sum) {
                        left++;
                    } else if (a[left] + a[right] > sum) {
                        right--;
                    } else {
                        count++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            System.out.println(findSum(a));
        }
    }
}
