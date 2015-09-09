package com.agenthun.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Agent Henry on 2015/9/9.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                int[] a = {i, 0};
                stack.push(a);
            } else {
                if (stack.empty() || stack.peek()[1] == 1) {
                    int[] a = {i, 1};
                    stack.push(a);
                } else {
                    stack.pop();
                    int currentLen = 0;
                    if (stack.empty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - stack.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "()(()";
        System.out.println("s = " + s);
        System.out.println("longestValidParentheses(s) = " + new LongestValidParentheses().longestValidParentheses(s));
    }
}
