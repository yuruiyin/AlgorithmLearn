package doubleContest.round26;

import java.util.ArrayList;
import java.util.List;

/**
 * A
 *
 * @author: yry
 * @date: 2020/5/16
 */
public class B {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> ansList = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    ansList.add(new String(j + "/" + i));
                }
            }
        }

        return ansList;
    }

}
