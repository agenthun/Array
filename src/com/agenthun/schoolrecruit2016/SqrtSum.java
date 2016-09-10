package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 数列的定义如下：
 * 数列的第一项为n，以后各项为前一项的平方根，求数列的前m项的和。
 * 输入
 * 输入数据有多组，每组占一行，由两个整数n（n<10000）和m(m<1000)组成，n和m的含义如前所述。
 * 输出
 * 对于每组输入数据，输出该数列的和，每个测试实例占一行，要求精度保留2位小数。
 */
public class SqrtSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            double sum = 0;
            double temp = n;
            for (int i = 0; i < m; i++) {
                sum += temp;
                temp = Math.sqrt(temp);
            }

            System.out.println(String.format("%.2f", sum));
        }
    }
}
