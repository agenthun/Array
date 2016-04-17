package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/17.
 * 今天，Alice 和 Bob 两个人发明了一个新的取石子游戏。我们将 n 枚石子摆放成一行，从左到右每枚石子有两个参数，能量ei 和得分ai 。
 * Alice 和 Bob 两人轮流决策，从左到右依次取石子，Alice 先手。每个回合，玩家可以选择下列两个操作之一：
 * 1. 消耗一个单位的能量，跳过这个回合。
 * 2. 取当前位置的石子。
 * 初始时，Alice 和 Bob分别有A和B单位的能量，两个玩家的目的都是最大化自己的得分，双方都采取最优决策，问游戏结束时，Alice 和 Bob 的得分分别为多少。
 * 题目给定A和B(0≤A≤10^9,0≤B≤10^9)同时给定石子个数n(1≤n≤100), 从左向右,每颗石子的能量e和得分a(所有数字均为正整数，e中元素均小于等于10^9,a中元素的和小于等于100)。
 * 请返回一个数组，其中第一个元素为Alice的得分，第二个元素为Bob的得分。
 * 测试样例：
 * 9,0,7,[66,2,6,2,8,4,3],[7,12,65,7,4,40,15]
 * 返回：
 * [112,38]
 */
public class Stones {
/*    public int[] result(int A, int B, int n, int[] e, int[] a) {
        // write code here
    }*/

    public static void main(String[] args) {
        int[] e = {66, 2, 6, 2, 8, 4, 3};
        int[] a = {7, 12, 65, 7, 4, 40, 15};
    }
}
