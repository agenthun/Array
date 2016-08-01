package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/7/30.
 * 特殊序列
 * Time Limit: 4000/2000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 小B准备开始新的职业生涯，由于大数据异常火爆，小B也打算去凑凑热闹，她应聘了一家数据处理公司。这不，面试官考察她的数据分析和编码能力。
 * 给了小B两个整数序列M和N，均按非递减顺序排列。面试官的问题是能否从序列M中找到p个连续元素构成一个子序列，同时从序列N中找到q个连续元素构成另一个子序列，使得它们满足条件：p个元素中的任何一个元素均小于q个元素中的任何一个？
 * 小B请你帮忙分析并编写这个程序。
 * 输入
 * 输入有若干组，每组包含四行，第一行为两个正整数na和nb（1<=na，nb<=100000），分别表示两个序列中元素的个数，第二行为p和q(1<=p<=na,1<=q<=nb），第三行为序列M，包含na个整数，第四行为序列N，包含nb个整数。
 * 输出
 * 对每组测试数据，单独输出一行，若能够找到则输出“YES”，否则输出“NO”（不含引号）。
 * <p>
 * 样例输入
 * 3 3
 * 2 1
 * 1 2 3
 * 3 4 5
 * 5 2
 * 3 1
 * 1 1 1 1 1
 * 2 2
 * 样例输出
 * NO
 * YES
 */
public class TwoArraySpecialSmallSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int na = scanner.nextInt();
            int nb = scanner.nextInt();
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int[] m = new int[na];
            int[] n = new int[nb];
            for (int i = 0; i < na; i++) {
                m[i] = scanner.nextInt();
            }
            for (int i = 0; i < nb; i++) {
                n[i] = scanner.nextInt();
            }

            boolean isOk = false;
            for (int i = p - 1; i < m.length; i++) {
                for (int j = 0; j < n.length - q + 1; j++) {
                    if (m[i] < n[j]) {
                        isOk = true;
                        break;
                    }
                }
                if (isOk) {
                    break;
                }
            }

            if (isOk) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
