package contest.contest335;

import java.util.*;

public class C {

    private static final int N = 1000000;

    private static boolean[] isPrime;

    // 求n以内的所有素数
    private void getAllPrimes(int n) {
        boolean[] isNotPrime = new boolean[n + 1];
        for (int i = 2; i * i <= n; i++) {
            if (isNotPrime[i]) {
                continue;
            }

            for (int j = i * i; j <= n; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            isPrime[i] = !isNotPrime[i];
        }
    }

    private List<Integer> getAllPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end; i++) {
            if (n % i == 0) {
                if (isPrime[i]) {
                    list.add(i);
                }
                if (isPrime[n / i]) {
                    list.add(n / i);
                }
            }
        }
        return list;
    }

    private void getAllPrimeFactors(int n, Map<Integer, Integer> countMap) {
        int end = (int) Math.sqrt(n);
        for (int i = 2; i <= end && n > 1; i++) {
            while (n % i == 0 && isPrime[i] && n > 1) {
                n /= i;
                countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                if (isPrime[n]) {
                    countMap.put(n, countMap.getOrDefault(n, 0) + 1);
                    n = 1;
                }
            }
        }
        if (isPrime[n]) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
    }

    public int findValidSplit(int[] nums) {
        if (isPrime == null) {
            isPrime = new boolean[N + 1];
            getAllPrimes(N);
        }

        int len = nums.length;

        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> tmpCountMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            tmpCountMap.clear();
//            List<Integer> factors = getAllPrimeFactors(nums[i]);
            getAllPrimeFactors(nums[i], tmpCountMap);
            for (int prime : tmpCountMap.keySet()) {
                countMap.put(prime, countMap.getOrDefault(prime, 0) + tmpCountMap.get(prime));
            }
        }

        System.out.println("hello");

        tmpCountMap.clear();
        Map<Integer, Integer> preCountMap = new HashMap<>();
        for (int i = 0; i < len - 1; i++) {
            tmpCountMap.clear();
//            List<Integer> factors = getAllPrimeFactors(nums[i]);
            getAllPrimeFactors(nums[i], tmpCountMap);
//            getAllPrimeFactors(nums[i], tmpCountMap);
            for (int prime : tmpCountMap.keySet()) {
                preCountMap.put(prime, preCountMap.getOrDefault(prime, 0) + tmpCountMap.get(prime));
                countMap.put(prime, countMap.getOrDefault(prime, 0) - tmpCountMap.get(prime));
            }

            boolean isOk = true;
            for (int prime : preCountMap.keySet()) {
                if (countMap.getOrDefault(prime, 0) > 0) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // [4,7,15,8,3,5]
        System.out.println(new C().findValidSplit(new int[]{4,7,15,8,3,5}));
    }
}
