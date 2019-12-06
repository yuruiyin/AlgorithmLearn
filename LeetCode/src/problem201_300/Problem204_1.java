package problem201_300;

public class Problem204_1 {

    public int countPrimes(int n) {
        int ans = 0;
        boolean[] nonPrimeArr = new  boolean[n];
        for (int i = 2; i * i < n; i++) {
            if (nonPrimeArr[i]) {
                continue;
            }

            for (int j = i * i; j < n; j += i) {
                nonPrimeArr[j] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            if (!nonPrimeArr[i]) {
                ans++;
            }
        }

        return ans;
    }

}
