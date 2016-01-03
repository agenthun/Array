package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/4.
 */
public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (C < E || G < A)
            return (C - A) * (D - B) + (G - E) * (H - F);
        if (D < F || H < B)
            return (C - A) * (D - B) + (G - E) * (H - F);

        int right = Math.min(C, G);
        int left = Math.max(A, E);
        int top = Math.min(H, D);
        int bottom = Math.max(F, B);

        return (C - A) * (D - B) + (G - E) * (H - F) - (right - left) * (top - bottom);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("strNums = ");
        String strNums = reader.readLine();
        String[] nums = strNums.split(" ");
        int[] pot = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pot[i] = Integer.parseInt(nums[i]);
        }

        System.out.println("computeArea(pot[0], pot[1], pot[2], pot[3], pot[4], pot[5], pot[6], pot[7]) = " + computeArea(pot[0], pot[1], pot[2], pot[3], pot[4], pot[5], pot[6], pot[7]));
    }
}
