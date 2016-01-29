package com.agenthun.nowcoder;

import java.util.Stack;

/**
 * Created by agenthun on 16/1/29.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 */
public class StackMin {

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> dataStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) return;
        if (dataStack.peek() == minStack.peek())
            minStack.pop();
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return Integer.MIN_VALUE;
        else {
            return minStack.peek();
        }
    }
}
