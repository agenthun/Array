package com.agenthun.array;

import java.util.ArrayList;

/**
 * Created by Agent Henry on 2015/7/22.
 */
public class FindSame {
    public static ArrayList<Integer> findSame(int[] a, int[] b) {
        ArrayList<Integer> ab = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                ab.add(a[i]);
                i++;
                j++;
            } else if (a[i] > b[j]) {
                j++;
            } else if (a[i] < b[j]) {
                i++;
            }
        }
        return ab;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4};
        int[] b = {1, 3, 5, 7, 9};
        ArrayList<Integer> sames = findSame(a, b);
        for (int i = 0; i < sames.size(); i++) {
            System.out.print(sames.get(i) + " ");
        }
    }
}
