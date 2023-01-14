package contest.contest326;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {

    private static List<Integer> allPrimes = new ArrayList<>();

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

    public int distinctPrimeFactors(int[] nums) {
        if (allPrimes.isEmpty()) {
            allPrimes = getAllPrimes(1000);
        }
        Set<Integer> primes = new HashSet<>();
        for (int num : nums) {
            for (int prime : allPrimes) {
                if (num % prime == 0) {
                    primes.add(prime);
                }
            }
        }

        return primes.size();
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
