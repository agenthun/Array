import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Agent Henry on 2015/7/16.
 */
public class FindMostFrequentInArray {
    public static int findMostFrequentInArray(int[] a) {
        int result = 0;
        int len = a.length;
        if (len == 0) return Integer.MAX_VALUE;

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
            if (m.containsKey(a[i])) {
                m.put(a[i], m.get(a[i]) + 1);
            } else {
                m.put(a[i], 1);
            }
        }

        int most = 0;
        Iterator iter = m.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            int key = (Integer) entry.getKey();
            int val = (Integer) entry.getValue();
            if (val > most) {
                most = val;
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 4, 4, 5, 4, 5, 5, 6, 6, 6, 6, 6, 6};
        System.out.println("mostFrequentInArray : " + findMostFrequentInArray(a));
    }
}
