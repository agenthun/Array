package com.agenthun.movetosiliconvalley;

import java.util.HashMap;

/**
 * Created by agenthun on 15/11/3.
 */
public class FindLongestConsequence {
    private int findLongestConsequence(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i : a) {
            if (map.containsKey(i)) continue;
            map.put(i, 1);
            if (map.containsKey(i - 1))
                max = Math.max(max, merge(map, i - 1, i));
            if (map.containsKey(i + 1))
                max = Math.max(max, merge(map, i, i + 1));
        }
        return max;
    }

    private int merge(HashMap<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }

    public static void main(String[] args) {
        int[] a = {8, 1, 9, 3, 2, 4};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println("findLongestConsequence(a) = " + new FindLongestConsequence().findLongestConsequence(a));
    }
}
