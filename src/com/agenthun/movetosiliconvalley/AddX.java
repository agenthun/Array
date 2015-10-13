package com.agenthun.movetosiliconvalley;

/**
 * Created by agenthun on 15/10/13.
 */
public class AddX {
    int addX(int a, int b) {
        int sum, carry;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 8;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("addX(a,b) = " + new AddX().addX(a, b));
    }
}
