package round670_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private List<Integer>[] adj;
        private int n;
        private int min;
        private List<Integer> targetNodeList;

        private int dfs(int root, boolean[] visited) {
            visited[root] = true;
            List<Integer> nextList = adj[root];
            int nodeCount = 1;
            int maxCount = 0;
            int sumChildCount = 0;
            for (int next: nextList) {
                if (visited[next]) {
                    continue;
                }

                int childCount = dfs(next, visited);
                sumChildCount += childCount;
                maxCount = Math.max(maxCount, childCount);
            }

            maxCount = Math.max(maxCount, n - 1 - sumChildCount);
            if (maxCount < min) {
                min = maxCount;
            }

            return nodeCount + sumChildCount;
        }

        private int dfs1(int root, boolean[] visited) {
            visited[root] = true;
            List<Integer> nextList = adj[root];
            int nodeCount = 1;
            int maxCount = 0;
            int sumChildCount = 0;
            for (int next: nextList) {
                if (visited[next]) {
                    continue;
                }

                int childCount = dfs1(next, visited);
                sumChildCount += childCount;
                maxCount = Math.max(maxCount, childCount);
            }

            maxCount = Math.max(maxCount, n - 1 - sumChildCount);
            if (maxCount == min) {
                targetNodeList.add(root);
            }

            return nodeCount + sumChildCount;
        }

        private int dfs2(int root, boolean[] visited, boolean hasMeet) {
            if (hasMeet && targetNodeList.contains(root)) {
                return root;
            }

            if (targetNodeList.contains(root)) {
                hasMeet = true;
            }

            visited[root] = true;
            List<Integer> nextList = adj[root];
            for (Integer next: nextList) {
                if (visited[next]) {
                    continue;
                }

                int res = dfs2(next, visited, hasMeet);
                if (res > 0) {
                    return res;
                }
            }

            return -1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                n = in.nextInt();
                adj = new ArrayList[n + 1];
                for (int i = 0; i < n - 1; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    if (adj[x] == null) {
                        adj[x] = new ArrayList<>();
                    }
                    adj[x].add(y);

                    if (adj[y] == null) {
                        adj[y] = new ArrayList<>();
                    }
                    adj[y].add(x);
                }

                min = Integer.MAX_VALUE;
                targetNodeList = new ArrayList<>();
                dfs(1, new boolean[n + 1]);
                dfs1(1, new boolean[n + 1]);
                int minCount = targetNodeList.size();
                if (minCount == 1) {
                    out.println("1 " + adj[1].get(0));
                    out.println("1 " + adj[1].get(0));
                    continue;
                }

                int leaf = -1;
                int leafConnectNode = -1;
                for (int i = 1; i <= n; i++) {
                    if (adj[i].size() == 1) {
                        leaf = i;
                        leafConnectNode = adj[i].get(0);
                        break;
                    }
                }

                int newEdgeNode = dfs2(leaf, new boolean[n + 1], false);
                out.println(leaf + " " + leafConnectNode);
                out.println(newEdgeNode + " " + leaf);
            }
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
    }

    public static void main(String[] args) {
        new Thread(null, () -> solve(), "1", 1 << 26).start();
    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

    }

}
