package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 * 股票交易
 * Time Limit: 1000/1000 MS (Others/C,C++) Memory Limit: 65536/65536 K (Others/C,C++)
 * Problem Description:
 * 假定我们用一个数组来记录某支股票的价格，数组中的每个元素表示每天的价格。
 * 如果你只能做一次交易（先买入，后卖出），问最多能赚多少？
 * 输入
 * 第一行数据是n个正整数，依次表示股票每天的价格。 n<100
 * 输出
 * 最大收益
 * <p>
 * 样例输入
 * 6
 * 8 2 4 3 7 5
 * 样例输出
 * 5
 */
public class StockExchange {
    private static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().trim().split(" ");

            int[] a = new int[str.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            System.out.println(maxProfit(a));
        }
    }
}
