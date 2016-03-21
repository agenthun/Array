package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by agenthun on 16/3/21.
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，
 * 若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。
 * 度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 * 输入描述:第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * 输出描述:一行输出最小面积
 * 输入例子:
 * 2
 * 0 0
 * 0 3
 * 输出例子: 9
 */
public class CutDownGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] pointX = new int[n];
            int[] pointY = new int[n];
            for (int i = 0; i < n; i++) {
                pointX[i] = scanner.nextInt();
                pointY[i] = scanner.nextInt();
            }

            int minPointX = pointX[0];
            int maxPointX = pointX[0];
            int minPointY = pointY[0];
            int maxPointY = pointY[0];
            for (int i = 1; i < n; i++) {
                if (pointX[i] > maxPointX) maxPointX = pointX[i];
                if (pointX[i] < minPointX) minPointX = pointX[i];
                if (pointY[i] > maxPointY) maxPointY = pointY[i];
                if (pointY[i] < minPointY) minPointY = pointY[i];
            }

            int maxLenX = maxPointX - minPointX;
            int maxLenY = maxPointY - minPointY;
            if (maxLenX > maxLenY) {
                BigInteger bigInteger = new BigInteger(String.valueOf(maxLenX));
                System.out.println(bigInteger.multiply(bigInteger));
            } else {
                BigInteger bigInteger = new BigInteger(String.valueOf(maxLenY));
                System.out.println(bigInteger.multiply(bigInteger));
            }
        }
    }
}
