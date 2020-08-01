package doubleContest.round29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/6/27
 */
public class B {

    private static List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i != i) {
                    list.add(num / i);
                }
            }
        }

        return list;
    }

    public int kthFactor(int n, int k) {
        List<Integer> factors = getAllFactors(n);
        Collections.sort(factors);
        if (factors.size() < k) {
            return -1;
        }

        return factors.get(k - 1);
    }

}
