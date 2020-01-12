package practice056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static Map<Long, Integer> nodePersonCountMap;
    private static Map<Long, Integer> nodeCountMap;
    private static List<Integer>[] adj;
    private static int n;
    private static int[] arr;
    private static int totalPersonCount;

    private static int[] calcCount(int parent, int cur, boolean[] nodeVisited) {
        int ansPersonCount = arr[cur];
        int ansNodeCount = 1;
        nodeVisited[cur] = true;
        for (Integer next: adj[cur]) {
            long edgeKey1 = cur * n + next;
            if (nodeVisited[next]) {
                continue;
            }

            int[] countArr = calcCount(cur, next, nodeVisited);
            nodePersonCountMap.put(edgeKey1, countArr[0]);
            nodeCountMap.put(edgeKey1, countArr[1]);
            ansPersonCount += countArr[0];
            ansNodeCount += countArr[1];
        }

        if (parent != 0) {
            nodePersonCountMap.put((long) (cur * n + parent), totalPersonCount - ansPersonCount);
            nodeCountMap.put((long) (cur * n + parent), n - ansNodeCount);
        }
        return new int[]{ansPersonCount, ansNodeCount};
    }

    private static void solve() throws IOException {
        n = nextInt();
        arr = new int[n+1];
        totalPersonCount = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = nextInt();
            totalPersonCount += arr[i];
        }

        adj = new ArrayList[n+1];
        Map<Long, Integer> wMap = new HashMap<>();
        List<Long> edgeList = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int first = nextInt();
            int second = nextInt();
            int w = nextInt();
            if (adj[first] == null) {
                adj[first] = new ArrayList<>();
            }

            adj[first].add(second);
            if (adj[second] == null) {
                adj[second] = new ArrayList<>();
            }

            adj[second].add(first);

            long min = Math.min(first, second);
            long max = Math.max(first, second);
            wMap.put(min * n + max, w);
            edgeList.add(min * n + max);
        }

        nodePersonCountMap = new HashMap<>();
        nodeCountMap = new HashMap<>();
        calcCount(0, 1, new boolean[n+1]);

        Map<Long, Long> ansMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (Integer next : adj[i]) {
                long min = Math.min(i, next);
                long max = Math.max(i, next);
                long key = min * n + max;
                long nextPersonCount = nodePersonCountMap.get((long) i * n + next);
                long curNodeCount = n - nodeCountMap.get((long) i * n + next);
                long value = nextPersonCount * 2 * wMap.get(key) * curNodeCount;
                ansMap.put(key, ansMap.getOrDefault(key, 0L) + value);
            }
        }
    
        for (Long edge: edgeList) {
            System.out.println(ansMap.get(edge));
        }

    }


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
