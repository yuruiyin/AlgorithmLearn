package contest.contest303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D {

    private int calcCount(int num) {
        int count = 0;
        while (num > 0) {
            count += num % 2;
            num >>>= 1;
        }
        return count;
    }

    public long countExcellentPairs(int[] nums, int k) {
        long ans = 0;
        int N = 30;
        Set<Integer>[] countSetArr = new HashSet[N + 1];
        Arrays.setAll(countSetArr, value -> new HashSet<>());
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int oneCount = Integer.bitCount(num);
            countSetArr[oneCount].add(num);
            set.add(num);
        }

        long[] sufSumCountArr = new long[N + 1];
        sufSumCountArr[N] = countSetArr[N].size();
        for (int i = N - 1; i >= 0; i--) {
            sufSumCountArr[i] = sufSumCountArr[i + 1] + countSetArr[i].size();
        }

        for (int i = 0; i <= N; i++) {
            if (countSetArr[i].isEmpty()) {
                continue;
            }
            int leftCount = k - i;
            if (leftCount <= 0) {
                ans += (long) countSetArr[i].size() * set.size();
            } else if (leftCount <= N) {
                ans += countSetArr[i].size() * sufSumCountArr[leftCount];
            }
        }

        return ans;
    }

}
