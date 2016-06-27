package com.agenthun.schoolrecruit2016;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by agenthun on 16/6/27.
 * 输入一个字符串，求出该字符串包含的字符集合
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 * 输入例子:
 * abcqweracb
 * 输出例子:
 * abcqwer
 */
public class StringSet {
    private static String getStringSet(String str) {
        if (str == null || str.length() == 0) return "";

        Set<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        for (Character c :
                set) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(getStringSet(str));
        }
    }
}
