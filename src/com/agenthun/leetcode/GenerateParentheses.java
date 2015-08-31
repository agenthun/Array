package com.agenthun.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agent Henry on 2015/8/30.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        dfs(list, "", n, n);
        return list;
    }

    //left, right 表示剩余的左括号,右括号数,满足右括号大于左括号
    private void dfs(ArrayList<String> list, String s, int left, int right) {
        if (left > right) return; //满足右括号大于左括号
        if (left == 0 & right == 0) {
            list.add(s);
            return;
        }
        if (left > 0) {
            dfs(list, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(list, s + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("n = " + n);
        List<String> result = new GenerateParentheses().generateParenthesis(n);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
