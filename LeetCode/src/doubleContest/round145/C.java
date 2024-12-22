package doubleContest.round145;

import java.util.*;

public class C {

    private static Set<Integer> allPrimes = new HashSet<>();

    private Set<Integer> getAllPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        Set<Integer> primeList = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            if (!isNotPrime[i]) {
                primeList.add(i);
            }
        }
        return primeList;
    }

    private int m;

    private int[] dp;

    private int rec(int n, boolean[] visited) {
        if (n == m) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int resMin = Integer.MAX_VALUE;
        int curN = n;
        for (int i = 0; curN > 0 ;i++) {
            int bit = curN % 10;
            if (bit < 9) {
                int nextN = (int) (n + Math.pow(10, i));
                if (!visited[nextN] && !allPrimes.contains(nextN)) {
                    visited[nextN] = true;
                    int tmpRes = rec(nextN, visited);
                    if (tmpRes != Integer.MAX_VALUE) {
                        resMin = Math.min(resMin, nextN + tmpRes);
                    }
                }
            }
            if (bit > 0) {
                int nextN = (int) (n - Math.pow(10, i));
                if (!visited[nextN] && !allPrimes.contains(nextN)) {
                    visited[nextN] = true;
                    int tmpRes = rec(nextN, visited);
                    if (tmpRes != Integer.MAX_VALUE) {
                        resMin = Math.min(resMin, nextN + tmpRes);
                    }
                }
            }
            curN /= 10;
        }

        return dp[n] = resMin;
    }

    public int minOperations(int n, int m) {
        if (allPrimes.isEmpty()) {
            allPrimes = getAllPrimes(9999);
        }

        if (allPrimes.contains(n) || allPrimes.contains(m)) {
            return -1;
        }

        dp = new int[10000];
        Arrays.fill(dp, -1);
        this.m = m;
        return n + rec(n, new boolean[10000]);
    }

}
