package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/26.
 * 在股市的交易日中，假设最多可进行两次买卖(即买和卖的次数均小于等于2)，
 * 规则是必须一笔成交后进行另一笔(即买-卖-买-卖的顺序进行)。给出一天中的股票变化序列，
 * 请写一个程序计算一天可以获得的最大收益。请采用实践复杂度低的方法实现。
 * 给定价格序列prices及它的长度n，请返回最大收益。保证长度小于等于500。
 * 测试样例：
 * [10,22,5,75,65,80],6
 * 返回：87
 */
public class Stock {
    public int maxProfit(int[] prices, int n) {
        int len = n;
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
        int[] x = {10, 22, 5, 75, 65, 80};
        int n = 6;
        System.out.println("maxProfit(x,n) = " + new Stock().maxProfit(x, n));
    }
}
