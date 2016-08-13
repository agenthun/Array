package com.agenthun.schoolrecruit2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daydreamer on 2016/8/13.
 * 输出前N个素数。不需要考虑整数溢出问题，也不需要使用大数处理算法。
 */
public class PrintNPrimes {
    public static List<Integer> getPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        int number = Integer.MAX_VALUE;
        int counter = 0;
        for (int i = 2; i < number; i++) {
            if (n <= 0) {
                break;
            }
            counter = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    counter++;
                    break;
                }
            }
            if (counter == 0) {
                list.add(i);
                n--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("n = " + n);
        List<Integer> list = getPrimes(n);
        for (Integer x :
                list) {
            System.out.println("x = " + x);
        }
    }
}
