package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 求组合数
 * 3->21
 */
public class ExternCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(getCount(n));
        }
    }

    private static long getCount(int n) {
        if (n == 1) return 3;
        if (n == 2) return 9;
        int temp = 1;
        if (n > 3) {
            temp = 3 * (n - 3) + ((n > 4) ? 6 * (n - 3 - 1) : 0);
        }
        long count = getPowerSelf(3, n) - 6 * (n - 2) * (temp);
        return count;
    }

    private static long getPowerSelf(long a, int n) {
        if (n == 0) return 1;
        if (n == 1) return a;
        if ((n & 1) == 0) {
            return getPowerSelf(a * a, n / 2);
        } else {
            return getPowerSelf(a * a, n / 2) * a;
        }
    }
}
