package com.agenthun.movetosiliconvalley;

import java.util.Stack;

/**
 * Created by agenthun on 15/10/28.
 */
public class CalculateRPNotation {
    double calculateRPNotation(char[] input) {
        int n = input.length;
        if (n == 0) return 0.0;
        double result = 0.0;
        boolean firstSign = true;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (input[i] == '/' || input[i] == '+' || input[i] == '*' || input[i] == '-') {
                if (firstSign) {
                    result = (double) stack.pop();
                    firstSign = false;
                }
                int first = stack.pop();
                switch (input[i]) {
                    case '/':
                        result = first / result;
                        break;
                    case '+':
                        result = first + result;
                        break;
                    case '-':
                        result = first - result;
                        break;
                    case '*':
                        result = first * result;
                        break;
                    default:
                        break;
                }
            } else {
                stack.push(input[i] - '0');
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
        System.out.println("calculateRPNotation(c) = " + new CalculateRPNotation().calculateRPNotation(c));
    }
}
