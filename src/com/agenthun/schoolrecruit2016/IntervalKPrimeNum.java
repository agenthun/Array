package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/30.
 * Time Limit: 6000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 数学老师上完课后，给小B布置了一个作业。尽管作业描述很简单，但结果却不那么简单。题目要求是，对于区间[a, b]中的所有正整数和给定的正整数k，
 * 计算其中最小因数为k的整数个数。遗憾的是，老师上课的时候，小B正在和周公神游天外，这是她不得不向你求助的原因。作为好朋友，你愿意帮助她吗？
 * 输入
 * 测试数据有多组，每组测试数据为一行，包括三个整数a、b和k（1=< a=<b <=2*10^9, 2=<k=2*10^9）
 * 输出
 * 对每组测试数据，在单独的行中输出问题结果
 * <p>
 * 样例输入
 * 1 10 2
 * 12 23 3
 * 6 19 5
 * 样例输出
 * 5
 * 2
 * 0
 * <p>
 * Hint
 * 示例1中满足要求的数为2, 4, 6, 8, 10。
 * 示例2中满足要求的数为15, 21。
 * 示例3中没有满足要求的数。
 */
public class IntervalKPrimeNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long k = scanner.nextLong();

            long count = 0;
            for (long i = a; i <= b; i++) {
                if (i % k == 0) {
                    boolean isLeast = true;
                    long temp = k;
                    while (temp > 2) {
                        temp--;
                        if (i % temp == 0) {
                            isLeast = false;
                        }
                    }
                    if (isLeast) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static boolean isLeastPrime(long a, long k) {
        if (k == 2 || k == 3) return true;
        if (k % 2 == 0) return false;
        for (long i = 3; i <= Math.min((long) Math.sqrt(a), k); i++) {
            if ((a % i) == 0) {
                return false;
            }
        }
        return true;
    }
}
