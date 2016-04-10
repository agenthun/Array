package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/10.
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),现在要从a2 ,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 * 输入描述:
 * 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
 * 输出描述:
 * 输出答案。
 * 输入例子:
 * 5
 * 1 2 3 7 8
 * 输出例子:
 * 4
 */
public class MaxDeleteDiff {
    private static int maxDiff(int[] array) {
        int max = Integer.MIN_VALUE;
        int maxDelete = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i] - array[i - 1]);
        }
        for (int i = 1; i < array.length - 1; i++) {
            maxDelete = Math.min(maxDelete, Math.max(array[i + 1] - array[i - 1], max));
        }
        return maxDelete;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            int res = maxDiff(array);
            System.out.println(res);
        }
    }
}
