package com.agenthun.schoolrecruit2016;

import java.util.HashMap;

/**
 * Created by agenthun on 16/7/28.
 * 数组中和为k的最长子串
 */
public class MaxSumLength {
    int maxSumLength(int[] a, int k) {
        if (a == null || a.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int len = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[0];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
}
