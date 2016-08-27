package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/8/27.
 * 某环形公路上有N个站点，分别记为A1......An，
 * 从Ai到A（ i+1）的距离为Di。An到A1的距离为Do，假设Do=Dn=1，保存在数组D（N）中，
 * 现在要求你与一个函数，能够高效的计算出公路上任意两点的最近距离，要求空间复杂度不能超过O(N)。
 */
public class CircleRoad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            double[] D = new double[N];
            double[] sumD = new double[N];
            double sum = 0;
            for (int i = 0; i < N; i++) {
                D[i] = scanner.nextDouble();
                sum += D[i];
                sumD[i] = sum;
            }

            int i = scanner.nextInt(); //任意两点,i,j
            int j = scanner.nextInt();

            double temp = Math.abs(sumD[i] - sumD[j]);
            double result = Math.min(temp, sum - temp);
            System.out.println("result = " + result);
        }
    }
}
