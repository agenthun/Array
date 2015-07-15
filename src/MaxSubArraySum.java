/**
 * Created by Agent Henry on 2015/7/15.
 */
public class MaxSubArraySum {
    public static int max(int m, int n) {
        return m > n ? m : n;
    }

    public static int maxSubArray0(int[] a) {
        int len = a.length;
        int All[] = new int[len];
        int End[] = new int[len];
        All[0] = End[0] = a[0];
        All[len - 1] = End[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            End[i] = max(End[i - 1] + a[i], a[i]);
            All[i] = max(End[i], All[i - 1]);
        }
        return All[len - 1];
    }

    public static int maxSubArray1(int[] a) {
        int len = a.length;
        int nAll = a[0];
        int nEnd = a[0];
        for (int i = 1; i < len; i++) {
            nEnd = max(nEnd + a[i], a[i]);
            nAll = max(nEnd, nAll);
        }
        return nAll;
    }

    private static int begin = 0;
    private static int end = 0;

    public static int maxSubArray3(int[] a) {
        int maxSum = Integer.MIN_VALUE;
        int nSum = 0; //包含子数组最后一位的最大值
        int nStart = 0;
        for (int i = 0; i < a.length; i++) {
            if (nSum < 0) {
                nSum = a[i];
                nStart = i;
            } else {
                nSum += a[i];
            }
            if (nSum > maxSum) {
                maxSum = nSum;
                begin = nStart;
                end = i;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {1, -2, 4, 8, -4, 7, -1, -5};
        System.out.println("maxSum = " + maxSubArray3(a));
        System.out.println("begin = " + begin + ", end = " + end);
    }
}
