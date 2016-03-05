package com.agenthun.schoolrecruit2016;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Henry on 2016/3/5.
 * 题目描述
 * 一条长l的笔直的街道上有n个路灯，若这条街的起点为0，终点为l，第i个路灯坐标为ai，每盏灯可以覆盖到的最远距离为d，为了照明需求，所有灯的灯光必须覆盖整条街，但是为了省电，要是这个d最小，请找到这个最小的d。
 * 输入描述:
 * 每组数据第一行两个整数n和l（n大于0小于等于1000，l小于等于1000000000大于0）。第二行有n个整数(均大于等于0小于等于l)，为每盏灯的坐标，多个路灯可以在同一点。
 * 输出描述:
 * 输出答案，保留两位小数。
 * 输入例子:
 * 7 15
 * 15 5 3 7 9 14 0
 * 输出例子:
 * 2.5
 */
public class StreetLamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }
            Arrays.sort(a);

            double[] d = new double[n + 1];
            d[0] = (double) a[0];
            d[n] = (double) (l - a[n - 1]);
            for (int i = 0; i < n - 1; i++) {
                d[i + 1] = ((double) a[i + 1] - (double) a[i]) / 2;
            }
            Arrays.sort(d);
            DecimalFormat df = new DecimalFormat("#.00");
            System.out.println(df.format(d[n]));
        }
    }
}
