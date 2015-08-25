package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/25.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();
        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        String digitsTemp = digits.trim();
        if (digitsTemp == null || digitsTemp.length() < 1) return list;
        char[] temp = new char[digitsTemp.length()];
        dfsGetStr(digitsTemp, 0, temp, map, list);
        return list;
    }

    private void dfsGetStr(String digits, int index, char[] temp, String[] map, List<String> list) {
        if (index == digits.length()) {
            list.add(new String(temp));
            return;
        }
        char c = digits.charAt(index);
        for (int i = 0; i < map[c - '0'].length(); i++) {
            temp[index] = map[c - '0'].charAt(i);
            dfsGetStr(digits, index + 1, temp, map, list);
        }
    }

    public static void main(String[] args) {
        String s = "23";
        System.out.println("s = " + s);
        List<String> list = new LetterCombinationsOfAPhoneNumber().letterCombinations(s);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
