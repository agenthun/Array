package com.agenthun.leetcode;

/**
 * Created by Agent Henry on 2015/8/11.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
/*        int len = 0;
        LinkedHashMap<Character, Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer temp = hashMap.get(s.charAt(i));
            if (temp == null) hashMap.put(s.charAt(i), 1);
            else {
                System.out.println(hashMap);
                len = Math.max(len, hashMap.size());
                hashMap.remove(s.charAt(i));
//                hashMap.clear();
                hashMap.put(s.charAt(i), 1);
            }
        }
        return Math.max(len, hashMap.size());*/

/*        int maxLen = 0, left = 0;
        int prev[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            if (prev[s.charAt(i)] >= left)
                left = prev[s.charAt(i)] + 1;
            prev[s.charAt(i)] = i;
            if (maxLen < i - left + 1)
                maxLen = i - left + 1;
        }
        return maxLen;*/

        int i = 0, j = 0;
        int maxLen = 0;
        boolean[] exist = new boolean[256];
        while (j < s.length()) {
            if (exist[s.charAt(j)]) {
                maxLen = Math.max(maxLen, j - i);
                while (s.charAt(i) != s.charAt(j)) {
                    exist[s.charAt(i)] = false;
                    i++;
                }
                i++;
                j++;
            } else {
                exist[s.charAt(j)] = true;
                j++;
            }
        }
        maxLen = Math.max(maxLen, s.length() - i);
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        System.out.println(str);
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(str));
    }
}
