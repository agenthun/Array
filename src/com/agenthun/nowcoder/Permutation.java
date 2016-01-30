package com.agenthun.nowcoder;

import java.util.*;

/**
 * Created by Henry on 2016/1/21.
 */
public class Permutation {
    //    public static ArrayList<String> permutation(String str) {
//        ArrayList<String> list = new ArrayList<>();
//
//        if (str == null || str.length() == 0) return list;
//
//        char[] output = str.toCharArray();
//        Arrays.sort(output);
//
//        list.add(String.valueOf(output));
//        if (str.length() == 1) return list;
//
//        int point = 0;
//        char temp1 = output[point];
//        output[point] = output[++point];
//        output[point] = temp1;
//
//        while (!String.valueOf(output).equals(str)) {
//            list.add(String.valueOf(output));
//            if (point == output.length - 1) {
//                char temp = output[point];
//                output[point] = output[0];
//                output[0] = temp;
//                point = 0;
//            } else {
//                char temp = output[point];
//                output[point] = output[++point];
//                output[point] = temp;
//            }
//        }
//
//        Collections.sort(list);
//        return list;
//    }
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();

        if (str == null || str.length() == 0) return result;

        char[] output = str.toCharArray();
        TreeSet<String> set = new TreeSet<>();
        permutation(output, 0, set);
        result.addAll(set);
        return result;
    }

    public static void permutation(char[] str, int i, TreeSet<String> set) {
        if (i >= str.length)
            return;
        if (i == str.length - 1) {
            set.add(String.valueOf(str));
        } else {
            for (int j = i; j < str.length; j++) {
                char temp = str[j];
                str[j] = str[i];
                str[i] = temp;
                permutation(str, i + 1, set);
                temp = str[j];
                str[j] = str[i];
                str[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String str = "aab";
        System.out.println("str = " + str);
        List<String> list = Permutation(str);
        for (String s :
                list) {
            System.out.println(s);
        }
    }
}
