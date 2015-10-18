package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;

/**
 * Created by agenthun on 15/10/18.
 */
public class PascalTriangle {
    ArrayList<ArrayList<Integer>> pascalTriangle(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (n < 1) return result;

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        result.add(row1);
        if (n == 1) return result;

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("n = " + n);
        ArrayList<ArrayList<Integer>> res = new PascalTriangle().pascalTriangle(n);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
