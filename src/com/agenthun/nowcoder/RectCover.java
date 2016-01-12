package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/12.
 */
public class RectCover {
    public static int rectCover(int target) {
        if (target == 0) return 1;
        if (target <= 3) return target;

        int a = 1, b = 1, i = 2, res = 0;
        while (i <= target) {
            res = a + b;
            a = b;
            b = res;
            i++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n = ");
        String str = reader.readLine();
        int n = Integer.parseInt(str);

        System.out.println("rectCover(n) = " + rectCover(n));
    }
}
