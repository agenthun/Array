package com.agenthun.movetosiliconvalley;

import java.util.Stack;

/**
 * Created by agenthun on 15/10/27.
 */
public class GenRPNotation {
    String genRPNotation(char[] input) {
        int n = input.length;
        if (n == 0) return "";
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (input[i] == '/' || input[i] == '+' || input[i] == '*' || input[i] == '-') {
                if (result == "") result = result + stack.pop();
                char first = stack.pop();
                result = "(" + first + input[i] + result + ")";
            } else {
                stack.push(input[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] c = {'5', '8', '4', '/', '+'};
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
        System.out.println("genRPNotation(c) = " + new GenRPNotation().genRPNotation(c));
    }
}
