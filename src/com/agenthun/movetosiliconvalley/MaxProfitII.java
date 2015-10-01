package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/1.
 */
public class MaxProfitII {
    int maxProfitII(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int[] currProfit = new int[len];
        int[] futureProfit = new int[len];
        int maxProfit = 0;
        int low = prices[0];

        for (int i = 1; i < len; i++) {
            low = Math.min(low, prices[i]);
            currProfit[i] = Math.max(currProfit[i - 1], prices[i] - low);
        }

        int high = prices[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            high = Math.max(high, prices[i]);
            if (i < len - 1) {
                futureProfit[i] = Math.max(futureProfit[i + 1], high - prices[i]);
            }
            maxProfit = Math.max(maxProfit, currProfit[i] + futureProfit[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1, 9};
        for (int i = 0; i < prices.length; i++) {
            System.out.print(prices[i] + " ");
        }
        System.out.println();
        System.out.println("maxProfitII(prices) = " + new MaxProfitII().maxProfitII(prices));
    }
}
