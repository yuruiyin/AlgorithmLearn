package contest.contest352;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> findPrimePairs(int n) {
        List<Integer> primeList = getAllPrimes(n);
        int size = primeList.size();
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 0; i < size; i++) {
            isPrime[primeList.get(i)] = true;
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int x = primeList.get(i);
            int y = n - x;
            if (x <= y && isPrime[y]) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                ansList.add(list);
            }
        }
        return ansList;
    }

}
