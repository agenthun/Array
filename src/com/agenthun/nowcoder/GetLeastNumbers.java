package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by agenthun on 16/1/14.
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0) return res;
        if (k > input.length) return res;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }
}
