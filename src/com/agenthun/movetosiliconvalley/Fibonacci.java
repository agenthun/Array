package com.agenthun.movetosiliconvalley;

import java.util.HashMap;

/**
 * Created by agenthun on 15/10/1.
 */
public class Fibonacci {
    int fib(int n) {
        if (n <= 2) return 1;
        int a = 1, b = 1, i = 3, res = 0;
        while (i <= n) {
            res = a + b;
            a = b;
            b = res;
            i++;
        }
        return res;
    }

    int fibII(int n, HashMap<Integer, Integer> hashMap) {
        if (n <= 2) return 1;
        if (hashMap.containsKey(n))
            return hashMap.get(n);
        int res = fibII(n - 1, hashMap) + fibII(n - 2, hashMap);
        hashMap.put(n, res);
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println("n = " + n);
        System.out.println("非递归");
        System.out.println("fib(n) = " + new Fibonacci().fib(n));
        System.out.println("递归");
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        System.out.println("fibII(n,hashmap) = " + new Fibonacci().fibII(n, hashmap));
    }
}
