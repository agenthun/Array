package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by agenthun on 16/6/14.
 */
public class Main2 {
    public static int getResult(int a, int b) {
        int res = 0;
        int x = (int) Math.min(b, a / 0.9);
        for (int i = 5; i <= x; i += 5) {
            if ((i * 0.9f) >= a) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(getResult(a, b));
        }
    }
}
