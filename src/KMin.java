/**
 * Created by Agent Henry on 2015/7/17.
 */
public class KMin {

    public static int QuickSort(int[] a, int l, int r, int indexK) {
        if (l > r) return Integer.MIN_VALUE;
        int i = l + 1;
        int j = r;
        int x = a[i];
        while (i < j) {
            while (i < j && a[j] >= x) j--;
            if (i < j) a[i++] = a[j];
            while (i < j && a[i] < x) i++;
            if (i < j) a[j--] = a[i];
        }
        a[i] = x;
        if (i + 1 == indexK)
            return x;
        else if (i + 1 > indexK)
            return QuickSort(a, l, i - 1, indexK);
        else
            return QuickSort(a, i + 1, r, indexK);
    }

    private static int findKMin(int[] a, int k) {
        if (a == null || a.length < k) return Integer.MIN_VALUE;
        return QuickSort(a, 0, a.length - 1, k);
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 2, 6, 8, 0, 6};
        int kMin = findKMin(a, 4);
        System.out.println("kMin = " + kMin);
    }
}
