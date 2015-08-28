package com.agenthun.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Agent Henry on 2015/8/28.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.keySet().contains(ch)) stack.push(ch);
            else if (map.values().contains(ch)) {
                if (!stack.empty() && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s1 = "(]";
        String s2 = "(])]";
        String s3 = "()[]{}";
        System.out.println("s1 = " + s1 + ", is " + new ValidParentheses().isValid(s1));
        System.out.println("s2 = " + s2 + ", is " + new ValidParentheses().isValid(s2));
        System.out.println("s3 = " + s3 + ", is " + new ValidParentheses().isValid(s3));
    }
}
