package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/25.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] map = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mmo",
                "pqrs",
                "tuv",
                "wxyz"
        };
        ArrayList<String> list = new ArrayList<>();
        char[] temp = new char[digits.length()];
        dfsGetStr(digits, 0, temp, map, list);
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
