package contest.contest408;

import java.util.ArrayList;
import java.util.List;

public class B {

    private List<Integer> getAllPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    public int nonSpecialCount(int l, int r) {
        List<Integer> primeList = getAllPrimes((int) Math.sqrt(r));
        int ans = 0;
        for (int prime : primeList) {
            int num = prime * prime;
            if (num >= l && num <= r) {
                ans++;
            }
        }
        return r - l + 1 - ans;
    }

}
