package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/6/14.
 * 在最近几场魔兽争霸赛中，赫柏对自己的表现都不满意。
 * 为了尽快提升战力，赫柏来到了雷鸣交易行并找到了幻兽师格丽，打算让格丽为自己的七阶幻兽升星。
 * 经过漫长的等待以后，幻兽顺利升到了满星，赫柏很满意，打算给格丽一些小费。
 * 赫柏给小费是有原则的：
 * 1.最终给格丽的钱必须是5的倍数；
 * 2.小费必须占最终支付费用的5%~10%之间（包含边界）。
 * 升星总共耗费A魔卡，赫柏身上带了B魔卡，赫柏想知道他有多少种支付方案可供选择。
 * 注：魔卡是一种货币单位，最终支付费用=本该支付的+小费
 * 输入描述:
 * 多组测试数据，请处理到文件结束。
 * 对于每组测试数据：
 * 包含两个整数A和B。
 * 保证：
 * 1<=A,B<=2,000,000,000，A<=B。
 * 输出描述:
 * 输出一个整数，代表方案数。
 * 输入例子:
 * 4 100
 * 23 100
 * 输出例子:
 * 0
 * 1
 */
public class WarcraftPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double A = scanner.nextDouble();//本该支付的费用
            double B = scanner.nextDouble();//总金额

            int start = (int) Math.ceil(A / 0.95);
            int end = (int) Math.floor(A / 0.9);
            int res = 0;
            while (start % 5 != 0 && start <= end) {
                start++;
            }

            for (int i = start; i <= end && i <= B; i += 5) {
                if (i % 5 == 0) {
                    res++;
                }
            }

            System.out.println(res);
        }
    }
}
