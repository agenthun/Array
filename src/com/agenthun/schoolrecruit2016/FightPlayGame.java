package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/3/19.
 */
public class FightPlayGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // 怪物的数量
            int n = input.nextInt();
            // 小易初始能力值
            int ability = input.nextInt();
            // 定义怪物数组
            int[] monsters = new int[n];
            // 输入每个怪物的防御力
            for (int i = 0; i < n; i++) {
                monsters[i] = input.nextInt();
            }
            // 小易遇怪
            for (int i = 0; i < n; i++) {
                if (ability > monsters[i] || ability == monsters[i]) {
                    ability = ability + monsters[i];
                } else {
                    ability = ability + GCF(ability, monsters[i]);
                }
            }
            // 打完怪了，输出结果
            System.out.println(ability);
        }
    }

    public static int GCF(int A, int B) {
        if (B == 0) {
            return A;
        } else
            return GCF(B, A % B);
    }

    private static int findCommonDivisor(int n, int m) {
        while (n % m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }
}
