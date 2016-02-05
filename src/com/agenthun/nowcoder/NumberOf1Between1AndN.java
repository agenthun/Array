package com.agenthun.nowcoder;

/**
 * Created by agenthun on 16/2/5.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOf1Between1AndN {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        int i = 1;
        int current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 1)
                count = count + (before + 1) * i;
            else if (current == 0)
                count = count + before * i;
            else if (current == 1)
                count = count + before * i + after + 1;

            i = i * 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println("n = " + n);
        System.out.println("NumberOf1Between1AndN_Solution(n) = " + NumberOf1Between1AndN_Solution(n));
    }
}
