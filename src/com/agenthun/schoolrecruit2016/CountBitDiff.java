package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/16.
 * 世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？
 * 输入例子:1999 2299
 * 输出例子:7
 */
public class CountBitDiff {
    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        int mn = m ^ n;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((mn & 0x1) == 1) {
                count++;
            }
            mn = mn >> 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int m = 1999, n = 2299;
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        System.out.println("countBitDiff(m,n) = " + new CountBitDiff().countBitDiff(m, n));
    }
}
