package com.agenthun.nowcoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by agenthun on 16/1/9.
 */
public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                buffer.append("%20");
            } else {
                buffer.append(str.charAt(i));
            }
        }
        return new String(buffer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input string :");
        StringBuffer str = new StringBuffer(reader.readLine());

        System.out.println("replaceSpace(str) = " + replaceSpace(str));
    }
}
