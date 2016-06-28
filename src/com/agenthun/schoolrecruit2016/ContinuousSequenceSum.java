package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/29.
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
 * 输入描述:
 * 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
 * 输出描述:
 * 一行输出答案。
 * 输入例子:
 * 3 100 2
 * 1 2 3
 * 输出例子:
 * 2
 */
public class ContinuousSequenceSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] tempStr = scanner.nextLine().split(" ");
            int n = Integer.parseInt(tempStr[0]);
            int t = Integer.parseInt(tempStr[1]);
            int c = Integer.parseInt(tempStr[2]);
            int[] a = new int[n];
            String[] tempArg = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tempArg[i]);
            }

            int count = getCount(n, t, c, a);
            System.out.println(count);
        }
    }

    private static int getCount(int n, int t, int c, int[] a) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < c; i++) {
            sum += a[i];
        }
        if (sum <= t) count++;

        for (int index = c; index < n; index++) {
            sum = sum + a[index] - a[index - c];
            if (sum <= t)
                count++;
        }
        return count;
    }
}
