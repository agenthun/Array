package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agenthun on 15/12/21.
 */
public class PascalTriangleII {
    List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 3;
        System.out.println("k = " + k);
        List<Integer> list = new PascalTriangleII().getRow(k);
        for (Integer i :
                list) {
            System.out.print(i + " ");
        }
    }
}
