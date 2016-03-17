package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/3/17.
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 测试样例：1
 * 返回：["0","1"]
 */
public class GrayCode {
    public String[] getGray(int n) {
        // write code here
        String[] code = new String[(int) Math.pow(2, n)];
        if (n == 1) {
            code[0] = "0";
            code[1] = "1";
            return code;
        }
        String[] last = getGray(n - 1);
        for (int i = 0; i < last.length; i++) {
            code[i] = "0" + last[i];
            code[code.length - i - 1] = "1" + last[i];
        }
        return code;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println("n = " + n);
        String[] res = new GrayCode().getGray(n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
