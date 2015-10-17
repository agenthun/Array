package com.agenthun.movetosiliconvalley;

import com.agenthun.array.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry on 2015/9/20.
 */
public class MinDelete {
    List<Integer> minDelete(int[] a) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer, Integer> bt = new HashMap<>();
        int[] dp = new int[a.length];
        int maxCount = 0;
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] >= a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (maxCount < dp[i]) {
                        maxCount = dp[i];
                        bt.put(i, j);
                        end = i;
                    }
                }
            }
        }

        int k = a.length - 1;
        while (k >= 0) {
            while (k > end) {
                list.add(a[k]);
                k--;
            }
            k--;
            if (bt.containsKey(end)) {
                end = bt.get(end);
            } else end = -1;
        }
        return list;
    }

    public static void lis(int[] a) {
        int len = a.length;
        int[] dp = new int[len];
        dp[0] = 1;

        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && dp[j] > dp[i] - 1) {
                    dp[i] = dp[j] + 1;
                    System.out.println("dp[i] = " + a[j]);
                }
            }
        }
        System.out.println(dp[len - 1]);
    }

    public static void main(String[] args) {
        int[] a = {1, 6, 3, 9, 5, 80, 7, 10, 9, 14, 11};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        List<Integer> list = new MinDelete().minDelete(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("xxxx");

        int[] b = new int[a.length];
        lis(a);
/*        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }*/
    }
}
