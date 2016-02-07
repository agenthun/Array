package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/7.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return "";

        String[] words = str.split(" ");
        if (words.length == 0) return str;

        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }

        int i;
        StringBuffer stringBuffer = new StringBuffer();
        for (i = 0; i < words.length - 1; i++) {
            stringBuffer.append(words[i] + " ");
        }
        stringBuffer.append(words[i]);
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
//        String s = "student. a am I";
        String s = " ";
        System.out.println("s = " + s);

        System.out.println("ReverseSentence(s) = " + new ReverseSentence().ReverseSentence(s));
    }
}
