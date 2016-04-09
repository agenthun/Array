package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/4/9.
 * 现在有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1,y1)。
 * 每次移动一步，都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转。问最少需要移动几步。
 * 输入描述:
 * 一行五个整数r,x,y,x1,y1(1≤r≤100000,-100000≤x,y,x1,y1≤100000)
 * 输出描述:
 * 输出一个整数，表示答案
 * 输入例子:
 * 2 0 0 0 4
 * 输出例子:
 * 1
 * in:1941 4776 3688 -45690 3688
 * out:13
 */
public class MoveCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();

            double distance = Math.sqrt((long) (x - x1) * (x - x1) + (long) (y - y1) * (y - y1));
            double len = distance / (r << 1);
            int n = (int) len;
            System.out.println(n);
        }
    }
}
