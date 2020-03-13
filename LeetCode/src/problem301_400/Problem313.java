package problem301_400;

public class Problem313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int primeSize = primes.length;
        int[] indexArr = new int[primeSize];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primeSize; j++) {
                int val = primes[j] * dp[indexArr[j]];
                if (val < min) {
                    min = val;
                }
            }

            for (int j = 0; j < primeSize; j++) {
                if (primes[j] * dp[indexArr[j]] == min) {
                    indexArr[j]++;
                }
            }

            dp[i] = min;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Problem313().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }

}
