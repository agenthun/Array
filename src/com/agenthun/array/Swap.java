package com.agenthun.array;

/**
 * Created by agenthun on 16/4/4.
 */
public class Swap {
    //有溢出
    private static void swap1(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);
    }

    private static void swap2(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        int a = 2, b = 3;
        System.out.println("a = " + a + ", b = " + b);
        swap1(a, b);
        swap2(a, b);
        System.out.println("a = " + a + ", b = " + b);
    }
}
