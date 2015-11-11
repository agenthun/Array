package com.agenthun.movetosiliconvalley;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by agenthun on 15/11/12.
 */
public class Anagrams {
    ArrayList<ArrayList<String>> anagrams(ArrayList<String> strs) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        for (String str :
                strs) {
            char[] letters = str.toCharArray();
            Arrays.sort(letters);
            String anagram = new String(letters);
            if (hm.containsKey(anagram)) {
                ArrayList<String> list = hm.get(anagram);
                list.add(str);
                hm.put(anagram, list);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hm.put(anagram, list);
            }
        }
        for (ArrayList<String> list :
                hm.values()) {
            if (list.size() > 1) res.add(list);
        }
        return res;
    }
}
