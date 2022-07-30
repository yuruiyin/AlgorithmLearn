package contest.contest303;

import java.util.HashSet;
import java.util.Set;

public class D_1 {

    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0;
        int N = 30;
        long[] countArr = new long[N + 1];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int oneCount = Integer.bitCount(num);
            countArr[oneCount] += set.add(num) ? 1 : 0;
        }

        long[] sufSumCountArr = new long[N + 1];
        sufSumCountArr[N] = countArr[N];
        for (int i = N - 1; i >= 0; i--) {
            sufSumCountArr[i] = sufSumCountArr[i + 1] + countArr[i];
        }

        for (int i = 0; i <= N; i++) {
            if (countArr[i] == 0) {
                continue;
            }
            int leftCount = k - i;
            if (leftCount <= 0) {
                ans += countArr[i] * set.size();
            } else if (leftCount <= N) {
                ans += countArr[i] * sufSumCountArr[leftCount];
            }
        }

        return ans;
    }

}
