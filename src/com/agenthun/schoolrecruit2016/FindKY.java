package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 */
public class FindKY {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // x
            int x = input.nextInt();
            // 第k个
            int k = input.nextInt();

            int y = 1;
            int count = 0;

            for (int i = 0; i < 32; i++) {
                if ((x & (1 << i)) == 0) {
                    int tt = x | (1 << i);
                    if ((x + y) == tt) {
                        count++;
                        if (count == k) break;
                    }
                }
            }
            //输出结果
            System.out.println(y);
        }
    }
}
