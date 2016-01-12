package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/11.
 */
public class JumpFloorII {
    public static int jumpFloorII(int target) {
        if (target < 0) return Integer.MIN_VALUE;
        if (target == 0) return 0;

        return mypower(2, target - 1);
    }

    private static int mypower(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        if ((n & 0x01) == 0) {
            return mypower(x * x, n / 2);
        } else {
            return mypower(x * x, n / 2) * x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n = ");
        String str = reader.readLine();
        int n = Integer.parseInt(str);

        System.out.println("jumpFloor(n) = " + jumpFloorII(n));
    }
}
