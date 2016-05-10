package com.agenthun.schoolrecruit2016;

import java.util.Scanner;

/**
 * Created by agenthun on 16/5/10.
 * 解密字符串，字符串中的数字表示前面的字串重复了多少次。例如输入b2bc3d1，输出bbbcbcbcd。
 */
public class SolveString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();

            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder num = new StringBuilder();
            StringBuilder res = new StringBuilder();
            boolean isNum = false;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                    num.append(str.charAt(i));
                    isNum = true;
                } else {
                    if (isNum) {
                        int times = Integer.parseInt(num.toString());
                        while (times > 0) {
                            res.append(stringBuilder.toString());
                            times--;
                        }
                        isNum = false;
                        stringBuilder = new StringBuilder();
                        num = new StringBuilder();
                    }
                    stringBuilder.append(str.charAt(i));
                }
            }

            if (isNum) {
                int times = Integer.parseInt(num.toString());
                while (times > 0) {
                    res.append(stringBuilder.toString());
                    times--;
                }
            }
            System.out.println("res = " + res.toString());
        }
    }
}
