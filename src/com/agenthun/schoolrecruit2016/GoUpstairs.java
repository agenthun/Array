package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/15.
 * 题目描述
 * 有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或者二级，要走上m级，共有多少走法？注：规定从一级到一级有0种走法。
 * 给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100。为了防止溢出，请返回结果Mod 1000000007的值。
 * 测试样例：3
 * 返回：2
 */
public class GoUpstairs {
    public int countWays(int n) {
        // write code here
        if (n <= 3) return n - 1;

        long a = 1, b = 2, i = 4;
        long res = 0;
        while (i <= n) {
            res = a + b;
            a = b;
            b = res;
            i++;
            if (res > 1000000007) res = res % 1000000007;
            if (a > 1000000007) a = a % 1000000007;
            if (b > 1000000007) b = b % 1000000007;
        }
        return (int) res;
    }
}
