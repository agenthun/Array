package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/11.
 */
public class IsPowerOf2 {
    boolean isPowerOf2(int n) {
        int temp = n & (n - 1);
        return ((n != 0) && (temp == 0));
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("n = " + n);
        System.out.println("isPowerOf2(n) = " + new IsPowerOf2().isPowerOf2(n));

        n = 7;
        System.out.println("n = " + n);
        System.out.println("isPowerOf2(n) = " + new IsPowerOf2().isPowerOf2(n));
    }
}
