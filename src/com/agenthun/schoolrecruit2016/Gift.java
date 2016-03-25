package com.agenthun.schoolrecruit2016;

import java.util.Arrays;

/**
 * Created by agenthun on 16/3/25.
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。
 * 请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 * 测试样例：
 * [1,2,3,2,2],5
 * 返回：2
 */
public class Gift {
    public int getValue(int[] gifts, int n) {
        // write code here
        Arrays.sort(gifts);
        int val = gifts[n >> 1];
        int count = 0;
        for (int i = 0; i < gifts.length; i++) {
            if (gifts[i] == val) {
                count++;
            }
        }
        return (count <= n / 2) ? 0 : val;
    }

    public static void main(String[] args) {
        int[] gifts = {1, 2, 3, 2, 2};
        int n = 5;
        for (int i = 0; i < gifts.length; i++) {
            System.out.print(gifts[i] + " ");
        }
        System.out.println("n = " + n);
        System.out.println("getValue(gifts,n) = " + new Gift().getValue(gifts, n));
    }
}
