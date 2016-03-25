package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by agenthun on 16/3/22.
 * 腾讯2017暑期实习笔试模拟:对两个很大整数进行乘法计算
 * Input:
 * 213897129837128937123
 * 43502789523572345
 * Output:
 * 9305121819000846375051201723846663435
 */

public class BigMultiply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String strX = scanner.next().trim();
            String strY = scanner.next().trim();
            BigInteger bigIntegerX = new BigInteger(strX);
            BigInteger bigIntegerY = new BigInteger(strY);
            BigInteger bigInteger = bigIntegerX.multiply(bigIntegerY);
            System.out.printf(bigInteger.toString());
        }
    }
}