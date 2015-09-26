package com.agenthun.movetosiliconvalley;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by agenthun on 15/9/26.
 */
public class MaxHistogramArea {
    public int maxHistogramArea(int[] height) {
        int n = height.length, max = 0;
        Stack<Integer> bars = new Stack<>();
        bars.add(-1);
        for (int i = 0; i < n; i++) {
            int prev = bars.peek();
            if (prev < 0 || height[i] >= height[prev]) {
                bars.add(i);
            } else {
                prev = bars.pop();
                max = Math.max(max, height[prev] * (i - bars.peek() - 1));
                i--;
            }
        }

        while (bars.peek() != -1) {
            int prev = bars.pop();
            max = Math.max(max, height[prev] * (n - bars.peek() - 1));
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.print("length: ");
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] height = new int[length];
        System.out.print("height[]: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");
        for (int i = 0; i < length; i++) {
            height[i] = Integer.parseInt(s[i]);
        }

        System.out.println("maxHistogramArea(height) = " + new MaxHistogramArea().maxHistogramArea(height));
    }
}
