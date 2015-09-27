package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by agenthun on 15/9/27.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numberList.add(i);
        }
        k--;
        int mod = 1;
        for (int i = 1; i <= n; i++) {
            mod *= i;
        }
        String result = "";

        for (int i = 0; i < n; i++) {
            mod = mod / (n - i);
            int curIndex = k / mod;
            k = k % mod;
            result += numberList.get(curIndex);
            numberList.remove(curIndex);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.printf("n = ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("k = ");
        int k = scanner.nextInt();

        System.out.println("getPermutation(n,k) = " + new PermutationSequence().getPermutation(n, k));
    }
}
