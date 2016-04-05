package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/4/5.
 * N个节点的二叉树有多少种形态
 * N=3,5种
 * N=2,2种
 * f(3)=f(2)+f(1)*f(1)+f(2)
 * f(n)=f(n-1)+f(n-2)*f(1)+f(n-3)*f(2)+..+f(1)*f(n-2)+f(n-1)=C(2n,n)/(n+1)
 * 1,1,2,5,14,42,132
 */
public class TreeNodeType {
    private static int treeNodeType(int n) {
        if (n == 0) return 1;
        return (int) ((jiechen(2 * n) / jiechen(n) / jiechen(n)) / (n + 1));
    }

    private static double jiechen(int n) {
        double res = 1d;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n = " + n);
        System.out.println("treeNodeType(n) = " + treeNodeType(n));
    }
}
