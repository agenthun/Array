import java.util.Arrays;

/**
 * Created by Agent Henry on 2015/7/17.
 */
public class FindSum {

    public static void findSum(int[] a, int sum) {
        Arrays.sort(a);
        int begin = 0;
        int end = a.length - 1;
        while (begin < end) {
            if (a[begin] + a[end] < sum) begin++;
            else if (a[begin] + a[end] > sum) end--;
            else {
                System.out.println(a[begin] + " + " + a[end] + " = " + sum);
                begin++;
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 7, 17, 2, 6, 3, 14};
        findSum(a, 20);
    }
}
