package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/12.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return null;
        int[] b = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if (i == 0) b[i] = 1;
            else b[i] = b[i - 1] * A[i - 1];
        }

        int right = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            b[i] = b[i] * right;
            right = A[i] * right;
        }
        return b;
    }
}
