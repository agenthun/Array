package com.agenthun.array;

/**
 * Created by agenthun on 16/4/4.
 * 最大公约数GCD
 * 最小公倍数LCM=A*B/最大公约数
 */
public class GCDAndLCM {
    //最大公约数
    private int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    //最小公倍数
    private int lcm(int a, int b) {
        int res = a * b / gcd(a, b);
        return res;
    }

    public static void main(String[] args) {
        int a = 6, b = 5;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("最大公约数gcd(a,b) = " + new GCDAndLCM().gcd(a, b));
        System.out.println("最小公倍数lcm(a,b) = " + new GCDAndLCM().lcm(a, b));
    }
}
