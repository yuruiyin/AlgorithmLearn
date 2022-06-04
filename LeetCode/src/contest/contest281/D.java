package contest.contest281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {

    private int gcd(int m, int n) {
        return m % n == 0 ? n : gcd(n, m % n);
    }

    public long countPairs(int[] nums, int k) {
        long ans = 0;
        List<Integer> factorList = new ArrayList<>();
        for (int i = 1; i * i <= k; i++) {
            if (k % i == 0) {
                factorList.add(i);
                if (i * i != k) {
                    factorList.add(k / i);
                }
            }
        }

        int[] countArr = new int[100001];
        for (int num : nums) {
            ans += countArr[k / gcd(k, num)];
            for (int factor : factorList) {
                if (num % factor == 0) {
                    countArr[factor]++;
                }
            }
        }
        return ans;
    }

}
