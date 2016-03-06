package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/6.
 * 有一个数组changes，changes中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，对于一个给定值x，请设计一个高效算法，计算组成这个值的方案数。
 * 给定一个int数组changes，代表所以零钱，同时给定它的大小n，另外给定一个正整数x，请返回组成x的方案数，保证n小于等于100且x小于等于10000。
 * 测试样例：[5,10,25,1],4,15
 * 返回：15
 * 测试样例：[5,10,25,1],4,0
 * 返回：1
 */
public class CountWays {
    public int countWays(int[] changes, int n, int x) {
        // write code here
        if (changes == null || changes.length == 0) return 0;
        int[] count = new int[x + 1];
        count[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + changes[i] <= x; j++) {
                count[j + changes[i]] += count[j];
            }
        }
        return count[x];
    }

    public static void main(String[] args) {
        int[] changes = {5, 10, 25, 1};
        int n = 4, x = 15;
        System.out.println("countWays(changes,n,x) = " + new CountWays().countWays(changes, n, x));
    }
}
