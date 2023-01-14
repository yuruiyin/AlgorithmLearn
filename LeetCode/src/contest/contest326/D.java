package contest.contest326;

import java.util.ArrayList;
import java.util.List;

public class D {

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

    public int[] closestPrimes(int left, int right) {
        if (allPrimes.isEmpty()) {
            allPrimes = new ArrayList<>();
            allPrimes = getAllPrimes(1000001);
        }

//        System.out.println(allPrimes.size());
        int size = allPrimes.size();
        int ansMin = Integer.MAX_VALUE;
        int leftIdx = -1;
        for (int i = 0; i < size; i++) {
            if (allPrimes.get(i) >= left) {
                leftIdx = i;
                break;
            }
        }

        if (leftIdx == -1) {
            return new int[]{-1, -1};
        }

        int rightIdx = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (allPrimes.get(i) <= right) {
                rightIdx = i;
                break;
            }
        }

        if (rightIdx == -1 || rightIdx == leftIdx) {
            return new int[]{-1, -1};
        }

        for (int i = leftIdx + 1; i <= rightIdx; i++) {
            int diff = allPrimes.get(i) - allPrimes.get(i - 1);
            if (diff < ansMin) {
                ansMin = diff;
            }
        }

        for (int i = leftIdx + 1; i <= rightIdx; i++) {
            int diff = allPrimes.get(i) - allPrimes.get(i - 1);
            if (diff == ansMin) {
                return new int[]{allPrimes.get(i - 1), allPrimes.get(i)};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("hello world");
        new D().closestPrimes(1, 1000000);
    }

}
