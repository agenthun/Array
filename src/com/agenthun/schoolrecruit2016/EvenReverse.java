package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/22.
 * 今天的计算机课上，老师给同学们出了一道题：
 * 输入n个数，请将其中的偶数的二进制反转。
 * eg：输入1 6 5
 * 其中6是偶数，二进制表示为110，反转后为011，代表3，所以最终输出1 3 5.
 * 小贱君最近脑子不怎么好使，想了半天也没想出来如何做，最后他向你寻求帮助了，帮帮可怜的小贱君吧！
 * 输入描述:
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * N --- 输入的数字个数
 * N个数：a0,a1,...,an-1
 * 保证：
 * 1<=N<=3000,0<=ai<=INT_MAX.
 * 输出描述:
 * 对于每组数据，输出N个整数。
 * 输入例子:
 * 5
 * 1 3 10 6 7
 * 6
 * 26 52 31 45 82 34
 * 输出例子:
 * 1 3 5 3 7
 * 11 11 31 45 37 17
 */
public class EvenReverse {
    private static void evenReverse(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & 0x01) == 0) {
                int j = 31;
                for (j = 31; j >= 0; j--) {
                    if ((a[i] & (1 << j)) != 0) {
                        break;
                    }
                }

                int len = j;
                int temp = 0;
                for (; j >= 0; j--) {
                    temp |= ((a[i] & (1 << (j))) != 0) ? (1 << (len - j)) : 0;
                }
                a[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            evenReverse(a);

            int i;
            for (i = 0; i < a.length - 1; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println(a[i]);
        }
    }
}
