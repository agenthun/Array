package com.agenthun.schoolrecruit2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by agenthun on 2016/10/20.
 * 小写字母字符串删除相同的字符使最后字典序最小
 * 输出
 * abacba
 * s1 = abc
 */
public class DeleteSameCharacter {

    private static String deleteSameChar(String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mapStr = new HashMap<>();
        Map<Character, Integer> mapSb = new HashMap<>();


        for (int i = 0; i < str.length(); i++) {
            if (!mapStr.containsKey(str.charAt(i))) {
                mapStr.put(str.charAt(i), i);
                sb.append(str.charAt(i));
                mapSb.put(str.charAt(i), i);
            } else {
                int index = mapSb.get(str.charAt(i));
                if (sb.charAt(index) > sb.charAt(index + 1)) {
                    sb.deleteCharAt(index);
                    sb.append(str.charAt(i));
                    mapSb.put(str.charAt(i), sb.length());
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "abacba";
        System.out.println(s1);
        System.out.println("s1 = " + deleteSameChar(s1));
    }
}
