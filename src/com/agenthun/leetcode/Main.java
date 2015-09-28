package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by agenthun on 15/9/28.
 */
public class Main {

    public int getPermutation(String s) {
        int n = 12;
        ArrayList<Character> numberList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numberList.add((char) (i + 'a' - 1));
        }
        int k = 0;

        String result = "";
        while (result.toString().equals(s) != true) {
            result = "";
            int mod = 1;
            for (int i = 1; i <= n; i++) {
                mod *= i;
            }

            for (int i = 0; i < n; i++) {
                mod = mod / (n - i);
                int curIndex = k / mod;
                k = k % mod;

                System.out.println("curIndex = " + curIndex);
                result += numberList.get(curIndex);
/*                 numberList.remove(curIndex);*/
            }
            k++;
        }

        return k;
    }

    public static void main(String[] args) throws IOException {
/*        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 0 || n > 10000) return;

        String[] s = new String[n];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < n; i++) {
            s[i] = bufferedReader.readLine();
        }*/

//        System.out.println("getPermutation(\"abcdefghijkl\") = " + new Main().getPermutation("abcdefghijkl"));
        System.out.println(new Main().getPermutation("hgebkflacdji") + "");
//        System.out.println("getPermutation(\"abcdefghijkl\") = " + new Main().getPermutation("gfkedhjblcia"));

    }
}
