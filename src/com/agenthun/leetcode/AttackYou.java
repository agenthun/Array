package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 15/10/9.
 */
public class AttackYou {
    double distance(int x1, int y1, int x2, int y2) {
        double sum2 = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
        return Math.sqrt(sum2);
    }

    public static void main(String[] args) throws IOException {
        int length = 9;
        int[] location = new int[length];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < length; i++) {
            location[i] = Integer.parseInt(s[i]);
        }

        int r = location[0];
        int attack = 0;
        double d1 = new AttackYou().distance(location[1], location[2], location[7], location[8]);
        double d2 = new AttackYou().distance(location[3], location[4], location[7], location[8]);
        double d3 = new AttackYou().distance(location[5], location[6], location[7], location[8]);
        if (r >= d1) attack++;
        if (r >= d2) attack++;
        if (r >= d3) attack++;
        System.out.println(String.valueOf(attack) + "X");
    }
}
