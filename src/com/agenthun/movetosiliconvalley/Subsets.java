package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by agenthun on 15/10/8.
 */
public class Subsets {
    ArrayList<ArrayList<Integer>> subsets(int[] s) {
        Arrays.sort(s);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < s.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            for (ArrayList<Integer> list : result) {
                temp.add(list);
                ArrayList<Integer> clone = new ArrayList<>(list);
                clone.add(s[i]);
                temp.add(clone);
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] s = {3, 1, 2};
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
        ArrayList<ArrayList<Integer>> result = new Subsets().subsets(s);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
