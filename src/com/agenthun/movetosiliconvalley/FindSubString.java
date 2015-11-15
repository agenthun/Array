package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by agenthun on 15/11/15.
 */
public class FindSubString {
    ArrayList<Integer> findSubstring(String s, String[] l) {
        ArrayList<Integer> result = new ArrayList<>();
        int tokenLength = l[0].length();
        int tokenCount = l.length;
        int length = tokenCount * tokenLength;

        HashMap<String, Integer> toFind = new HashMap<>();
        for (String str :
                l) {
            if (!toFind.containsKey(str))
                toFind.put(str, 1);
            else
                toFind.put(str, toFind.get(str) + 1);
        }
        for (int i = 0; i < s.length() - length + 1; i++) {
            String str = s.substring(i, i + length);
            int count = 0;
            HashMap<String, Integer> leftMap = new HashMap<>(toFind);
            for (int j = 0; j < tokenCount; j++) {
                String token = str.substring(j * tokenLength, (j + 1) * tokenLength);
                if (!leftMap.containsKey(token)) break;
                else {
                    leftMap.put(token, leftMap.get(token) - 1);
                    if (leftMap.get(token) >= 0) count++;
                    else break;
                }
            }
            if (count == tokenCount) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] l = {"foo", "bar"};
        System.out.println("s = " + s);
        System.out.print("l = ");
        for (int i = 0; i < l.length; i++) {
            System.out.print(l[i] + " ");
        }
        System.out.print("\nresult = ");
        ArrayList<Integer> res = new FindSubString().findSubstring(s, l);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}
