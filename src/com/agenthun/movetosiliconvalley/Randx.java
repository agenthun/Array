package com.agenthun.movetosiliconvalley;

import java.util.Random;

/**
 * Created by agenthun on 15/10/8.
 */
public class Randx {//产生1~10随机数
    int randx() {
        int row, col, idx;
        do {
            row = rand7();
            col = rand7();
            idx = col + (row - 1) * 7;
        } while (idx > 40);
        return 1 + (idx - 1) % 10;
    }

    private int rand7() {//产生1~7整数
        return 7;
    }

    public static void main(String[] args) {
        System.out.println("rand");
        System.out.println(new Randx().randx());
        System.out.println(new Randx().randx());
        System.out.println(new Randx().randx());
    }
}
