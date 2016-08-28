package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 * 比赛计分
 * Time Limit: 2000/1000 MS (Others/C,C++) Memory Limit: 65536/65536 K (Others/C,C++)
 * Problem Description:
 * 在奥运比赛中，有7个裁判为参赛的选手打分，分数为0~10分。
 * 选手最后的得分为：去掉一个最高分和一个最低分，其余5个分数的平均值，保留小数点后1位。请编写一个程序实现。
 * 输入
 * 输入数据有多组，每组占一行，包括7个整数m1….m7（0<m1…m7<=10）
 * 输出
 * 对于每个测试实例，要求输出最后平均值，平均值保留小数点后1位。
 * <p>
 * 样例输入
 * 5 6 7 7 8 9 8
 * 4 6 7 6 8 5 6
 * 样例输出
 * 7.2
 * 6.0
 */
public class MatchScore {
    private static final int N = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] a = new int[N];
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            double sum = 0;
            for (int i = 0; i < N; i++) {
                a[i] = scanner.nextInt();
                sum += a[i];
                if (a[i] > max) {
                    max = a[i];
                }
                if (a[i] < min) {
                    min = a[i];
                }
            }

            sum = sum - min - max;
            System.out.println(String.format("%.1f", sum / 5.0));
        }
    }
}
