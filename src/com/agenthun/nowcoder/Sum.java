package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/3/1.
 * 求1+2+3+...+n，要求不能使用
 * 乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum {
    public int Sum_Solution(int n) {
        int result = 0;
        int a = 1;
        boolean value = ((n != 0) && a == (result = Sum_Solution(n - 1)));
        result += n;
        return result;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("n = " + n);
        System.out.println("new Sum().Sum_Solution(n) = " + new Sum().Sum_Solution(n));
    }
}
