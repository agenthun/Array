package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/9/13.
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            stringBuffer.insert(0, mod);
        }
        while (stringBuffer.charAt(0) == '0' && stringBuffer.length() > 1) {
            stringBuffer.deleteCharAt(0);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        String a = "123";
        String b = "321";
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("multiply(a,b) = " + new MultiplyStrings().multiply(a, b));
    }
}
