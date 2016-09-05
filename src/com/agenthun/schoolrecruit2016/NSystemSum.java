package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/28.
 * 进制均值
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题。
 * 现在，她正在玩一个数值变换的游戏。
 * 她发现计算机中经常用不同的进制表示同一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示时为三位数1、7、3。按不同进制表达时，各个位数的和也不同，如上述例子中十六进制和八进制中各位数的和分别是18和11。
 * 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？她希望你能帮她解决这个问题？
 * 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 * 输入
 * 输入中有多组测试数据。每组测试数据为一个整数A（1=<A=<5000）。
 * 输出
 * 对每组测试数据，在单独的行中以X/Y的形式输出结果。
 * <p>
 * 样例输入
 * 5
 * 3
 * 样例输出
 * 7/3
 * 2/1
 */
public class NSystemSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int y = a - 2;
            int x = 0;
            for (int i = 2; i < a; i++) {
                x += sum(a, i);
            }
            int temp = gcd(x, y);
            System.out.println(x / temp + "/" + y / temp);
        }
    }

    private static int sum(int n, int x) {
        int res = 0;
        while (n != 0) {
            res += n % x;
            n = n / x;
        }
        return res;
    }

    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
