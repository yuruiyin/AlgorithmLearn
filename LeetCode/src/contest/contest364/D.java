package contest.contest364;

import java.util.*;

public class D {

    private static final int N = 100000;

    private static List<Integer> primeList;

    private static boolean[] isPrimeArr;

    private List<Integer>[] adj;

    private Map<Long, Integer> memoMap;

    private static boolean isPrime(int num) {
        int end = (int) Math.sqrt(num);
        for (int i = 2; i <= end; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void calcPrimeList() {
        primeList = new ArrayList<>();
        isPrimeArr = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (isPrime(i)) {
                primeList.add(i);
                isPrimeArr[i] = true;
            }
        }
    }

    private int dfs(int cur, int pre, boolean[] visited) {
        visited[cur] = true;
        long key = (long)cur * N + pre;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }
        if (isPrimeArr[cur]) {
            return 0;
        }

        List<Integer> nextList = adj[cur];
        int res = 1;
        for (int next: nextList) {
            if (visited[next]) {
                continue;
            }
            res += dfs(next, cur, visited);
        }
        memoMap.put(key, res);
        return res;
    }

    public long countPaths(int n, int[][] edges) {
        if (primeList == null) {
            calcPrimeList();
        }

        adj = new ArrayList[n + 1];
        Arrays.setAll(adj, value -> new ArrayList<>());
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        long ansCount = 0;
//        System.out.println(primeList.size());
        memoMap = new HashMap<>();
        for (int prime: primeList) {
            if (prime > n) {
                break;
            }
            List<Integer> nextList = adj[prime];
            boolean[] visited = new boolean[n + 1];
            visited[prime] = true;
            List<Integer> countList = new ArrayList<>();
            for (int next: nextList) {
                countList.add(dfs(next, prime, visited));
            }

            int size = countList.size();

            for (int i = 0; i < size; i++) {
                ansCount += countList.get(i);
            }

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    ansCount += (long)countList.get(i) * countList.get(j);
                }
            }
        }
        return ansCount;
    }

    public static void main(String[] args) {
        System.out.println(new D().countPaths(2, new int[][]{
                {2,1}
        }));
    }

}
