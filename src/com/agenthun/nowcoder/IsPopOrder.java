package com.agenthun.nowcoder;

import java.util.Stack;

/**
 * Created by agenthun on 16/2/2.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null
                || pushA.length == 0 || popA.length == 0
                || pushA.length != popA.length)
            return false;

        int point1 = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < popA.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
            } else {
                if (point1 == pushA.length) return false;
                else {
                    do {
                        stack.push(pushA[point1++]);
                    } while (stack.peek() != popA[i] && point1 != pushA.length);
                    if (stack.peek() == popA[i])
                        stack.pop();
                    else
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {4, 5, 3, 2, 1};
        int[] c = {4, 3, 5, 1, 2};
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        System.out.println("IsPopOrder(a,b) = " + IsPopOrder(a, b));
        System.out.println("IsPopOrder(a,c) = " + IsPopOrder(a, c));
    }
}
