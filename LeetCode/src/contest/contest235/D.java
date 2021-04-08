package contest.contest235;

import java.util.*;

/**
 * A
 *
 * @author: yry
 * @date: 2021/4/4
 */
public class D {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        boolean[] exist = new boolean[max + 1];
        for (int num : nums) {
            exist[num] = true;
        }

        int ans = 0;
        for (int i = 1; i <= max; i++) {
            int fst = -1;
            for (int j = i; j <= max; j+=i) {
                if (exist[j]) {
                    if (fst == -1) {
                        fst = j;
                    } else {
                        fst = gcd(fst, j);
                    }
                }
            }
            if (i == fst) {
                ans++;
            }
        }

        return ans;
    }

}
