package com.agenthun.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Henry on 2016/1/21.
 */
public class Permutation {
    public static ArrayList<String> permutation(String str) {
        if (str == null || str.length() == 0) return null;

        char[] output = str.toCharArray();
        Arrays.sort(output);

        ArrayList<String> list = new ArrayList<>();
        list.add(String.valueOf(output));

        int point = 0;
        char temp1 = output[point];
        output[point] = output[++point];
        output[point] = temp1;

        while (!String.valueOf(output).equals(str)) {
            list.add(String.valueOf(output));
            if (point == output.length - 1) {
                char temp = output[point];
                output[point] = output[0];
                output[0] = temp;
                point = 0;
            } else {
                char temp = output[point];
                output[point] = output[++point];
                output[point] = temp;
            }
        }

        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println("str = " + str);
        List<String> list = permutation(str);
        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
