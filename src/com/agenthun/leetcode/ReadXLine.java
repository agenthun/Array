package com.agenthun.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agenthun on 15/10/16.
 */
public class ReadXLine {
    public static void main(String[] args) throws IOException {
        List<String> lists = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("input");

        for (; ; ) {
            String s = bufferedReader.readLine();
            /*String[] ss = bufferedReader.readLine().split(" ");*/
            if (s == null || s.length() == 0)
                break;
            else
                lists.add(s);
        }

        System.out.println("result");

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i) + " ");
        }
        System.out.println("lists.size() = " + lists.size());

    }
}
