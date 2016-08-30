package com.agenthun.schoolrecruit2016;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by agenthun on 16/6/12.
 * 有一个投篮游戏。球场有p个篮筐，编号为0，1...，p-1。
 * 每个篮筐下有个袋子，每个袋子最多装一个篮球。有n个篮球，每个球编号xi 。
 * 规则是将数字为xi 的篮球投到xi 除p的余数为编号的袋里。若袋里已有篮球则球弹出游戏结束输出i，
 * 否则重复至所有球都投完。输出-1。问游戏最终的输出是什么？
 * 输入描述:
 * 第一行两个整数p,n（2≤p,n≤300)。p为篮筐数，n为篮球数。接着n行为篮球上的数字xi(0≤xi≤1e9)
 * 输出描述:
 * 输出游戏的结果
 * 输入例子:
 * 10 5
 * 0
 * 21
 * 53
 * 41
 * 53
 * 输出例子:
 * 4
 */
public class PlayBasketball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt(); //p个框
            int n = scanner.nextInt(); //n个球
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] x = new int[n];
            int res = -1;

            for (int i = 0; i < n; i++) {
                x[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                int temp = x[i] % p; //求余数
                if (map.containsKey(temp)) { //放到框里
                    res = i + 1;//计数
                    break;
                } else {
                    map.put(temp, 1);
                }
            }
            System.out.println(res);
        }
    }
}
