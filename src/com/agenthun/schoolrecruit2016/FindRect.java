package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/1.
 * 查找矩形
 * Time Limit: 2000/1000 MS (Java/Others) Memory Limit: 65536/65536 K (Java/Others)
 * Problem Description:
 * 对于一组水平线段及垂直线段，共有n条，已知其中必定存在一个若干条线段组成的矩形，输出这个矩形的左下角和右上角点，
 * 定义左下角点有最小的x值和y值，右上角点有最大的x值和y值。
 * 线段可以重合，线段必须恰好能组成矩形，即线段不能头或尾部超出矩阵边界，如下图：
 * <p>
 * 输入
 * 第一行为线段数 n (4 <= n <= 25)
 * 接下来有n行，每行为一条线段的首尾点坐标： xi yi xj yj
 * 坐标值范围 -1e9 <= x, y <= 1e9
 * 输出
 * 在一行输出矩形的左下角点和右上角点坐标：
 * xi yi xj yj
 * 根据定义有 xi < xj && yi < yj
 * <p>
 * 样例输入
 * 4
 * 0 0 0 1
 * 0 0 1 0
 * 0 1 1 1
 * 1 0 1 1
 * 样例输出
 * ​0 0 1 1
 */
public class FindRect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] positionX1Y1_X2Y2 = new int[n][4];
            for (int i = 0; i < n; i++) {
                positionX1Y1_X2Y2[i][0] = scanner.nextInt();
                positionX1Y1_X2Y2[i][1] = scanner.nextInt();
                positionX1Y1_X2Y2[i][2] = scanner.nextInt();
                positionX1Y1_X2Y2[i][3] = scanner.nextInt();
            }

            int xMin = positionX1Y1_X2Y2[0][0];
            int yMin = positionX1Y1_X2Y2[0][1];

            int xMax = positionX1Y1_X2Y2[0][2];
            int yMax = positionX1Y1_X2Y2[0][3];

            for (int i = 1; i < n; i++) {
                if (xMin > positionX1Y1_X2Y2[i][0]) {
                    xMin = positionX1Y1_X2Y2[i][0];
                }
                if (yMin > positionX1Y1_X2Y2[i][1]) {
                    yMin = positionX1Y1_X2Y2[i][1];
                }
                if (xMax < positionX1Y1_X2Y2[i][2]) {
                    xMax = positionX1Y1_X2Y2[i][2];
                }
                if (yMax < positionX1Y1_X2Y2[i][3]) {
                    yMax = positionX1Y1_X2Y2[i][3];
                }
            }
            System.out.print(xMin + " ");
            System.out.print(yMin + " ");
            System.out.print(xMax + " ");
            System.out.println(yMax);
        }
    }
}
