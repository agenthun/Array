package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/9/9.
 * 在1~1024位中，写函数将第id1位置1，读取第id2位1/0
 */
public class Read1024Bit {
    private static int[] task = new int[1024];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int id1 = scanner.nextInt();
            int id2 = scanner.nextInt();
            if (id1 >= 1 && id1 <= 1024 && id2 >= 1 && id2 <= 1024) {
                task[id1 - 1] = 1;
                if (task[id2 - 1] == 0) {
                    System.out.println(task[id2 - 1]);
                } else {
                    System.out.println(task[id2 - 1]);
                }
            } else {
                System.out.println(-1);
            }
        }
    }
}
