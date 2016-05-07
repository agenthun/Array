package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 * 你作为一名出道的歌手终于要出自己的第一份专辑了，你计划收录 n 首歌而且每首歌的长度都是 s 秒，每首歌必须完整地收录于一张 CD 当中。
 * 每张 CD 的容量长度都是 L 秒，而且你至少得保证同一张 CD 内相邻两首歌中间至少要隔 1 秒。为了辟邪，你决定任意一张 CD 内的歌数不能被 13 这个数字整除，
 * 那么请问你出这张专辑至少需要多少张 CD ？
 * 输入描述:
 * 每组测试用例仅包含一组数据，每组数据第一行为三个正整数 n, s, L。 保证 n ≤ 100 , s ≤ L ≤ 10000
 * 输出描述:
 * 输出一个整数代表你至少需要的 CD 数量。
 * 输入例子: 7 2 6
 * 输出例子: 4
 * in:26 1 100
 * out:2
 * in:27 1 27
 * out:3
 */
public class HowManyCDs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // 数量
            int n = input.nextInt();
            // 歌曲长度
            int S = input.nextInt();
            //CD 时间
            int L = input.nextInt();
            int CDNum;

            int num = (L + 1) / (S + 1);
            if ((num % 13) == 0) num--;
            if ((n % num) == 0) {
                CDNum = n / num;
            } else {
                CDNum = n / num + 1;
            }

            if ((n % 13) == 0 && n <= num) CDNum++;
            if (n % num == num - 1 && n % num != 0 && n % num % 13 == 0) CDNum++;

            //输出结果
            System.out.println(CDNum);
        }
    }
}
