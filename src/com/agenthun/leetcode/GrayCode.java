package com.agenthun.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by agenthun on 15/11/4.
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        if (n >= 0) {
            result.add(0);
            int t = 1;
            for (int i = 0; i < n; i++) {
                for (int j = result.size() - 1; j >= 0; j--) {
                    result.add(result.get(j) ^ t);
                }
                t <<= 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("n = " + n);
        List<Integer> a = new GrayCode().grayCode(n);
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
    }
}
