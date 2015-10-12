package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/12.
 */
public class IsPowerOf4 {
    boolean isPowerOf4(int n) {
        int temp = n & (n - 1);
        return ((n != 0) && (temp == 0) && ((n & 0xaaaaaaaa) == 0));
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("n = " + n);
        System.out.println("isPowerOf4(n) = " + new IsPowerOf4().isPowerOf4(n));

        n = 7;
        System.out.println("n = " + n);
        System.out.println("isPowerOf4(n) = " + new IsPowerOf4().isPowerOf4(n));
    }
}
