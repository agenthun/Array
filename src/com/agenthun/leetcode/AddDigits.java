package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by agenthun on 16/1/3.
 */
public class AddDigits {
    public static int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("num = ");
        String strNum = reader.readLine();
        int num = Integer.parseInt(strNum);
        System.out.println("addDigits(num) = " + addDigits(num));
    }
}
