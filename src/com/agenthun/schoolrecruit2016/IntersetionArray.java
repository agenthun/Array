package com.agenthun.schoolrecruit2016;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by agenthun on 16/8/26.
 * 给定2个大小分别为n, m的整数集合，分别存放在两个数组中 int A[n], B[m]，输出两个集合的交集
 */
public class IntersetionArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {-1, 0, 4, 5, 8, 9, 10, 11};

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setResult = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            setA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (setA.contains(b[i])) {
                setResult.add(b[i]);
            }
        }

        //输出交集结果
        for (Integer x :
                setResult) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
