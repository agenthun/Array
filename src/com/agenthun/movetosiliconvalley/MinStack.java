package com.agenthun.movetosiliconvalley;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by agenthun on 15/10/29.
 */
public class MinStack {
    Stack<Integer> s;
    Stack<Integer> s2;

    MinStack() {
        s = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
        if (s2.empty() || val < s2.peek()) s2.push(val);
        else s2.push(s2.peek());
    }

    public int min() {
        if (s2.empty()) throw new EmptyStackException();
        return s2.peek();
    }

    public int pop() {
        if (s2.empty() || s.empty()) throw new EmptyStackException();
        s2.pop();
        return s.pop();
    }
}
