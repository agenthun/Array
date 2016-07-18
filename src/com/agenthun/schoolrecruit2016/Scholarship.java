package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/18.
 * 小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
 * 每门课由平时成绩和考试成绩组成，满分为r。现在他知道每门课的平时成绩为ai ,
 * 若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
 * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
 * 输入描述:
 * 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，
 * 接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
 * 输出描述:
 * 一行输出答案。
 * 输入例子:
 * 5 10 9
 * 0 5
 * 9 1
 * 8 1
 * 0 1
 * 9 100
 * 输出例子:
 * 43
 */
public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long r = scanner.nextLong();
            long avg = scanner.nextLong();
            long[][] arr = new long[n][2];
            long score = 0;
            long total = avg * n;
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextLong();
                arr[i][1] = scanner.nextLong();
                score += arr[i][0];
            }

            sort(arr);
            long time = 0;
            int i = 0;
            while (score < total && i < n) {
                if (arr[i][0] < r) {
                    time += arr[i][1];
                    score++;
                    arr[i][0] += 1;
                } else {
                    i++;
                }
            }
            System.out.println(time);
        }
    }

    public static void sort(long[][] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j][1] > a[j + 1][1]) {
                    long temp = a[j][0];
                    long temp2 = a[j][1];
                    a[j][0] = a[j + 1][0];
                    a[j + 1][0] = temp;
                    a[j][1] = a[j + 1][1];
                    a[j + 1][1] = temp2;
                    flag = false;
                }
            }
            if (flag) return;
        }
    }
}
