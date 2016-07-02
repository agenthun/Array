package com.agenthun.schoolrecruit2016;

/**
 * Created by agenthun on 16/7/2.
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展开。
 * 此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；
 * 突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 * 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 * 测试样例：
 * 1
 * 返回：["down"]
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        int len = (2 << (n - 1)) - 1;
        String[] res = new String[len];
        int size = 1;
        res[0] = "down";
        for (int i = 2; i <= n; i++) {
            res[size] = "down";
            for (int j = size + 1; j < (size << 1) + 1; j++) {
                res[j] = res[(size << 1) - j] == "down" ? "up" : "down";
            }
            size = (size << 1) + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 2;
        String[] res = new FoldPaper().foldPaper(n);
        for (String s :
                res) {
            System.out.println(s);
        }
    }
}
