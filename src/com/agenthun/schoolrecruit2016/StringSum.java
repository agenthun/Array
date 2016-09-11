package com.agenthun.schoolrecruit2016;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by agenthun on 16/9/9.
 */
public class StringSum {
    private static boolean isNumber(String s) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(s);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] str = scanner.nextLine().split(",");
            if (str.length == 2) {
                if (isNumber(str[0]) && isNumber(str[1])) {
                    BigInteger bi1 = new BigInteger(str[0]);
                    BigInteger bi2 = new BigInteger(str[1]);
                    BigInteger sum = bi1.add(bi2);
                    System.out.println(sum.toString());
                } else {
                    System.out.println("error");
                }
            } else {
                System.out.println("error");
            }
        }
    }
}
