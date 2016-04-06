package com.agenthun.schoolrecruit2016;

import java.util.*;

/**
 * Created by agenthun on 16/4/6.
 * 请设计一个高效算法，再给定的字符串数组中，找到包含"Coder"的字符串(不区分大小写)，并将其作为一个新的数组返回。
 * 结果字符串的顺序按照"Coder"出现的次数递减排列，若两个串中"Coder"出现的次数相同，则保持他们在原数组中的位置关系。
 * 给定一个字符串数组A和它的大小n，请返回结果数组。保证原数组大小小于等于300,其中每个串的长度小于等于200。同时保证一定存在包含coder的字符串。
 * 测试样例：
 * ["i am a coder","Coder Coder","Code"],3
 * 返回：["Coder Coder","i am a coder"]
 */
public class FindCoder {
    public String[] findCoder(String[] A, int n) {
        // write code here
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < A.length; i++) {
            char[] chs = A[i].toLowerCase().toCharArray();
            int count = 0;
            for (int j = 0; j < chs.length - 4; j++) {
                if (combine(chs, j)) {
                    count++;
                    j += 4;
                }
            }
            if (count > 0)
                map.put(A[i], count);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });

        String[] res = new String[map.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(entries.get(i).getKey());
        }
        return res;
    }

    private boolean combine(char[] chs, int offset) {
        if (offset + 4 >= chs.length) return false;
        int left = 0;
        int right = 4;
        final String strCoder = "coder";
        while (left < right) {
            if (chs[left + offset] != strCoder.charAt(left)) return false;
            if (chs[right + offset] != strCoder.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] A = {
                "xbxcoderlafrcoderyuccoderjcoderefldcodersstujcoderelcoder",
                "Coder CoderCoder",
                "i am a coder",
                "Coder Coder",
                "Code",
                "dvfowcoderfencoderqekcoderbtmcoderehcoderriyjdcodermocoder"
        };
        int n = 3;
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
        System.out.println("n = " + n);
        String[] res = new FindCoder().findCoder(A, n);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
