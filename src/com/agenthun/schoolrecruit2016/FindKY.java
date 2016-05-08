package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 * 给定 x, k ，求满足 x + y = x | y 的第 k 小的正整数 y 。 | 是二进制的或(or)运算，例如 3 | 5 = 7。
 * 比如当 x=5，k=1时返回 2，因为5+1=6 不等于 5|1=5，而 5+2=7 等于 5 | 2 = 7。
 * in:1073741802 1073741823
 * out:144115187002114069
 */
public class FindKY {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // x
            int x = input.nextInt();
            // 第k个
            int k = input.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            String kBin = Integer.toString(k, 2);
            int index = kBin.length() - 1;

            while (k != 0) {
                if ((x & 1) == 0) {
                    stringBuilder.append(kBin.charAt(index--));
                    k /= 2;
                } else {
                    stringBuilder.append("0");
                }
                x >>>= 1;
            }
            BigInteger y = new BigInteger(stringBuilder.reverse().toString(), 2);
            //输出结果
            System.out.println(y);
        }
    }
}
