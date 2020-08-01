package round656_div3;

import java.io.*;
import java.util.*;

public class E {

    static class Task {

        class Edge {
            int v1;
            int v2;
            Edge(int v1, int v2) {
                this.v1 = v1;
                this.v2 = v2;
            }
        }

        private static final long MAX = 200001L;

        private boolean[] gVisited;
        private List<Integer>[] adj;
        private List<Edge> undirectedEdgeList;
        private Map<Long, Boolean> map;

        private void dfs(int from, boolean[] visited) throws Exception {
            gVisited[from] = true;
            List<Integer> nextList = adj[from];
            if (nextList == null) {
                return;
            }

            for (Integer next : nextList) {
                if (visited[next]) {
                    throw new Exception();
                }

                visited[next] = true;
                dfs(next, visited);
                visited[next] = false;
            }
        }

        private List<Integer> dfs1(int from) {
            gVisited[from] = true;
            List<Integer> nextList = adj[from];
            if (nextList == null) {
                return new ArrayList<>();
            }

            List<Integer> ansList = new ArrayList<>();
            for (Integer next : nextList) {
                List<Integer> tmpList = dfs1(next);
                ansList.addAll(tmpList);
            }

//            List<Integer> ansList1 = new ArrayList<>();
            for (Integer node : ansList) {
                long key = from * MAX + node;
                if (!map.containsKey(key)) {
                    continue;
                }
                map.put(key, true);
//                ansList1.add(node);
            }

            return ansList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 思路，判断已经有环，就返回NO，否则肯定可以YES
            // 1. dfs判断是否有环
            // 2. dfs过程中统计每个点可达的所有点
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                adj = new ArrayList[n + 1];
                undirectedEdgeList = new ArrayList<>();
                for (int i = 0; i < m; i++) {
                    int d = in.nextInt();
                    int v1 = in.nextInt();
                    int v2 = in.nextInt();
                    if (d == 0) {
                        undirectedEdgeList.add(new Edge(v1, v2));
                    } else {
                        if (adj[v1] == null) {
                            adj[v1] = new ArrayList<>();
                        }

                        adj[v1].add(v2);
                    }
                }

                gVisited = new boolean[n + 1];
                boolean isOk = true;
                for (int i = 1; i <= n; i++) {
                    if (adj[i] == null || gVisited[i]) {
                        continue;
                    }

                    try {
                        boolean[] visited = new boolean[n + 1];
                        visited[i] = true;
                        dfs(i, visited);
                    } catch (Exception e) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    out.println("NO");
                    continue;
                }

                // 原本无环
                out.println("YES");
                map = new HashMap<>();
                for (Edge edge : undirectedEdgeList) {
                    int v1 = edge.v1;
                    int v2 = edge.v2;
                    map.put(v1 * MAX + v2, false);
                    map.put(v2 * MAX + v1, false);
                }

                Arrays.fill(gVisited, false);
                for (int i = 1; i <= n; i++) {
                    if (adj[i] == null || gVisited[i]) {
                        continue;
                    }

                    dfs1(i);
                }

                for (Edge edge : undirectedEdgeList) {
                    int v1 = edge.v1;
                    int v2 = edge.v2;
                    if (map.getOrDefault(v1 * MAX + v2, false)) {
                        out.println(v1 + " " + v2);
                    } else {
                        out.println(v2 + " " + v1);
                    }
                }

                for (int i = 1; i <= n; i++) {
                    List<Integer> nextList = adj[i];
                    if (nextList == null) {
                        continue;
                    }

                    for (Integer next : nextList) {
                        out.println(i + " " + next);
                    }
                }
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
