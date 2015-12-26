package com.agenthun.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by agenthun on 15/12/26.
 */
public class UglyNumberII {
    int nthUglyNumber(int n) {
        List<Integer> x2 = new LinkedList<>();
        List<Integer> x3 = new LinkedList<>();
        List<Integer> x5 = new LinkedList<>();
        x2.add(1);
        x3.add(1);
        x5.add(1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.min(x2.get(0), Math.min(x3.get(0), x5.get(0)));
            if (x2.get(0) == result) x2.remove(0);
            if (x3.get(0) == result) x3.remove(0);
            if (x5.get(0) == result) x5.remove(0);
            x2.add(result * 2);
            x3.add(result * 3);
            x5.add(result * 5);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 6, m = 14;
        System.out.println("n = " + n);
        System.out.println("nthUglyNumber(n) = " + new UglyNumberII().nthUglyNumber(n));
        System.out.println("m = " + m);
        System.out.println("nthUglyNumber(m) = " + new UglyNumberII().nthUglyNumber(m));
    }
}
