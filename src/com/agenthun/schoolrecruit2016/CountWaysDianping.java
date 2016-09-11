package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 */
public class CountWaysDianping {
    private static int[] p = {1, 5, 10, 20, 50, 100};

    public static int countWays(int[] changes, int x) {
        // write code here
        if (changes == null || changes.length == 0) return 0;
        int[] count = new int[x + 1];
        count[0] = 1;

        for (int i = 0; i < changes.length; i++) {
            for (int j = 0; j + changes[i] <= x; j++) {
                count[j + changes[i]] += count[j];
            }
        }
        return count[x];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int re = countWays(p, n);
            System.out.println(re);
        }
    }
}
