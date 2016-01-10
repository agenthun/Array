package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/10.
 */
public class JumpFloor {
    public static int jumpFloor(int target) {
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

        System.out.println("jumpFloor(n) = " + jumpFloor(n));
    }
}
