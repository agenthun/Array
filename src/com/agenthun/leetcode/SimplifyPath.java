package com.agenthun.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by agenthun on 15/10/10.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        while (path.length() > 0 && path.charAt(path.length() - 1) == '/') {
            path = path.substring(0, path.length() - 1);
        }

        int start = 0;
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                stack.push(path.substring(start, i));
                start = i;
            } else if (i == path.length() - 1) {
                stack.push(path.substring(start));
            }
        }

        LinkedList<String> result = new LinkedList<>();
        int back = 0;
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("/.") || top.equals("/")) {

            } else if (top.equals("/..")) {
                back++;
            } else {
                if (back > 0) {
                    back--;
                } else {
                    result.push(top);
                }
            }
        }

        if (result.isEmpty()) return "/";
        StringBuilder stringBuilder = new StringBuilder();
        while (!result.isEmpty()) {
            String s = result.pop();
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/a/./b../../c/";
        System.out.println("path1 = " + path1);
        System.out.println("new SimplifyPath().simplifyPath(path1) = " + new SimplifyPath().simplifyPath(path1));
        System.out.println("path2 = " + path2);
        System.out.println("new SimplifyPath().simplifyPath(path2) = " + new SimplifyPath().simplifyPath(path2));

    }
}
