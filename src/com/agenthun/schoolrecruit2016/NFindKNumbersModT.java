package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 在1~10000中无序，缺3个数，找出这三个数，从小到大排成一组数，求这个数除7的余数
 * 如缺100，2，3，这个数23100 取余
 */
public class NFindKNumbersModT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 10000;
        while (scanner.hasNext()) {

            boolean[] a = new boolean[N];
            for (int i = 0; i < N - 3; i++) {
                int temp = scanner.nextInt();
                a[temp - 1] = true;
            }

            int[] b = new int[3];
            int j = 0;
            for (int i = 0; i < N; i++) {
                if (a[i] == false) {
                    b[j++] = i + 1;
                }
            }

            Arrays.sort(b);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < b.length; i++) {
                sb.append(b[i]);
            }

            BigInteger bigInteger = new BigInteger(sb.toString());
            BigInteger res = bigInteger.mod(new BigInteger("7"));
            System.out.println(res.toString());
        }
    }
}
