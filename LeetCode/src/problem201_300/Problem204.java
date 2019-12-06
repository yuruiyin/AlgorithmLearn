package problem201_300;

public class Problem204 {

    private boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        int ans = 0;
        int[] nonPrimeArr = new int[n];
        for (int i = 2; i < n; i++) {
            if (nonPrimeArr[i] == 1) {
                continue;
            }

            for (int j = 2; i * j < n; j++) {
                nonPrimeArr[i*j] = 1;
            }

            if (isPrime(i)) {
                ans++;
            }
        }

        return ans;
    }

}
