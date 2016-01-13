package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/13.
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("array = ");
        String str = reader.readLine();
        String[] aStr = str.split(" ");
        int[] a = new int[aStr.length];
        for (int i = 0; i < aStr.length; i++) {
            a[i] = Integer.parseInt(aStr[i]);
        }

        System.out.println("minNumberInRotateArray(a) = " + minNumberInRotateArray(a));
    }
}
