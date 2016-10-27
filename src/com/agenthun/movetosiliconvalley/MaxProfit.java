package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/2.
 */
public class MaxProfit {
    int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int profit = 0;
        int min = prices[0]; //注意是股票价的最小值
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]); //变更股票最小值
            profit = Math.max(profit, prices[i] - min); //更新最大获利
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 4, 3, 2, 1, 9};
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
        System.out.println("maxProfit(prices) = " + new MaxProfit().maxProfit(prices));
    }
}
