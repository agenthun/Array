package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Henry on 2015/11/10.
 */
public class GenStringByRule {
    void genStringByRule(String s, HashMap<Character, ArrayList<Character>> hashMap) {
        HashSet<String> set = new HashSet<>();
        set.add(s);
        genStringByRule(s, hashMap, 0, set, "");
    }

    void genStringByRule(String s, HashMap<Character, ArrayList<Character>> hashMap, int start, HashSet<String> set, String op) {
        if (start == s.length()) {
            if (!set.contains(op)) {
                System.out.println(op);
                set.add(op);
            }
            return;
        }

        ArrayList<Character> mutations = hashMap.get(s.charAt(start));
        if (mutations != null) {
            for (Character c : mutations) {
                if (c != null) genStringByRule(s, hashMap, start + 1, set, op + c);
            }
        }

        genStringByRule(s, hashMap, start + 1, set, op + s.charAt(start));
    }
}
