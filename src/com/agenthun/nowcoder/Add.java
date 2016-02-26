package com.agenthun.nowcoder;

/**
 * Created by huheng on 2/26/2016.
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    //Add 不用加减乘除做加法(#进军硅谷 - AddX 不用加减乘除求两数之和)
    public int Add(int num1, int num2) {
        int sum, carry;
        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return num1;
    }
}
