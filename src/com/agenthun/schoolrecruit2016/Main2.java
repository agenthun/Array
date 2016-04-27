package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/27.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            // 数量
            int n = input.nextInt();
            // 歌曲长度
            int S = input.nextInt();
            //CD 时间
            int L = input.nextInt();

            int num = L / (S);
            while (num > 0) {
                int len = num * S + 1 * (num - 1);
                if (len <= L && num % 13 != 0) {
                    break;
                }
                num--;
            }
            int CDNum = (int) Math.ceil((double) n / num);

            //输出结果
            System.out.println(CDNum);
        }
    }
}
