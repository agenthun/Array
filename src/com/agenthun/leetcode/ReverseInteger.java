package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/16.
 */
public class ReverseInteger {
    public int reverse(int x) {
        int result;
        String s = Integer.toString(x);
        if (x < 0) s = s.substring(1) + s.charAt(0);
        StringBuilder stringBuilder = new StringBuilder(s).reverse();
        try {
            result = Integer.parseInt(stringBuilder.toString());
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int x1 = 1534236469, x2 = -123;
        int y1, y2;
        System.out.println("x1 = " + x1 + ", x2 = " + x2);

        y1 = new ReverseInteger().reverse(x1);
        y2 = new ReverseInteger().reverse(x2);
        System.out.println("y1 = " + y1 + ", y2 = " + y2);
    }
}
