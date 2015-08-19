package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/18.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                return false;
            }
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int a1 = 12321, a2 = 123321, a3 = 10, a4 = 1000000001;
        System.out.println("a1 = " + a1 + ", a2 = " + a2 + ", a3 = " + a3 + ", a4 = " + a4);
        boolean r1 = new PalindromeNumber().isPalindrome(a1);
        boolean r2 = new PalindromeNumber().isPalindrome(a2);
        boolean r3 = new PalindromeNumber().isPalindrome(a3);
        boolean r4 = new PalindromeNumber().isPalindrome(a4);
        System.out.println("r1 = " + r1 + ", r2 = " + r2 + ", r3 = " + r3 + ", r4 = " + r4);
    }
}
