package contest.contest428;

import java.util.*;

public class B {

    private double[][] rateArr;

    private List<Integer>[] adj;

    private int n;

    private double[] maxCurrencyArr;

    private void dfs(int curIdx) {
        List<Integer> nextList = adj[curIdx];
        for (int next : nextList) {
            if (maxCurrencyArr[next] == 0) {
                maxCurrencyArr[next] = maxCurrencyArr[curIdx] * rateArr[curIdx][next];
                dfs(next);
            } else {
                double nextRate = maxCurrencyArr[curIdx] * rateArr[curIdx][next];
                if (nextRate > maxCurrencyArr[next]) {
                    maxCurrencyArr[next] = nextRate;
                    dfs(next);
                }
            }
        }
    }

    private void createSomeInfos(Map<String, Integer> idxMap, List<List<String>> pairs, double[] rates) {
        adj = new ArrayList[n];
        Arrays.setAll(adj, value -> new ArrayList<>());
        rateArr = new double[n][n];
        for (int i = 0; i < pairs.size(); i++) {
            List<String> pair = pairs.get(i);
            int idx1 = idxMap.get(pair.get(0));
            int idx2 = idxMap.get(pair.get(1));
            adj[idx1].add(idx2);
            adj[idx2].add(idx1);
            rateArr[idx1][idx2] = rates[i];
            rateArr[idx2][idx1] = 1.0 / rates[i];
        }
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Set<String> currencySet = new HashSet<>();
        for (List<String> pair: pairs1) {
            currencySet.add(pair.get(0));
            currencySet.add(pair.get(1));
        }

        for (List<String> pair: pairs2) {
            currencySet.add(pair.get(0));
            currencySet.add(pair.get(1));
        }

        Map<String, Integer> idxMap = new HashMap<>();
        int idx = 0;
        for (String currency: currencySet) {
            idxMap.put(currency, idx++);
        }

        this.n = idx;
        maxCurrencyArr = new double[n];
        maxCurrencyArr[idxMap.get(initialCurrency)] = 1.0;
        createSomeInfos(idxMap, pairs1, rates1);
        dfs(idxMap.get(initialCurrency));
        createSomeInfos(idxMap, pairs2, rates2);
        for (int i = 0; i < n; i++) {
            if (maxCurrencyArr[i] == 0) {
                continue;
            }
            dfs(i);
        }

        return maxCurrencyArr[idxMap.get(initialCurrency)];
    }

}
