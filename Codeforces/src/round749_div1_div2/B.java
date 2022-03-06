package round749_div1_div2;

import java.io.*;
import java.util.*;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private List<Set<Integer>> setList;

        private void dfs(Set<Integer>[] adj, int cur, boolean[] visited, Set<Integer> set) {
            visited[cur] = true;
            Set<Integer> nextList = adj[cur];
            if (nextList == null) {
                return;
            }
            set.add(cur);

            for (int next : nextList) {
                if (visited[next]) {
                    continue;
                }
                dfs(adj, next, visited, set);
            }
        }

        private List<int[]> bfs(Set<Integer>[] adj, int n) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(1);
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            List<int[]> edgeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();
                    Set<Integer> nextSet = adj[node];
                    for (int next : nextSet) {
                        if (visited[next]) {
                            continue;
                        }

                        edgeList.add(new int[]{node, next});
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            return edgeList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                Set<Integer>[] adj = new HashSet[n + 1];
                int oneNode = -1;
                for (int i = 0; i < m; i++) {
                    int a = in.nextInt();
                    int b = in.nextInt();
                    int c = in.nextInt();
                    oneNode = a;

                    if (adj[a] == null) {
                        adj[a] = new HashSet<>();
                    }
                    adj[a].add(c);
                    if (adj[c] == null) {
                        adj[c] = new HashSet<>();
                    }
                    adj[c].add(a);
                }

                LinkedList<Integer> bList = new LinkedList<>();
                for (int i = 1; i <= n; i++) {
                    if (adj[i] == null) {
                        bList.add(i);
                    }
                }

                setList = new ArrayList<>();

                boolean[] visited = new boolean[n + 1];
                for (int i = 1; i <= n; i++) {
                    if (visited[i] || adj[i] == null) {
                        continue;
                    }

                    Set<Integer> set = new HashSet<>();
                    dfs(adj, i, visited, set);
                    if (!set.isEmpty()) {
                        setList.add(set);
                    }
                }

                if (setList.size() == 1) {
                    for (int b : bList) {
                        adj[oneNode].add(b);
                        adj[b] = new HashSet<>();
                        adj[b].add(oneNode);
                    }
                } else {
                    int size = setList.size();
                    for (int i = 0; i < size - 1; i++) {
                        Set<Integer> curSet = setList.get(i);
                        Set<Integer> nextSet = setList.get(i + 1);
                        int curNode = curSet.iterator().next();
                        int nextNode = nextSet.iterator().next();
                        if (bList.isEmpty()) {
                            adj[curNode].add(nextNode);
                            adj[nextNode].add(curNode);
                        } else {
                            int b = bList.poll();
                            adj[curNode].add(b);
                            adj[nextNode].add(b);
                            adj[b] = new HashSet<>();
                            adj[b].add(curNode);
                            adj[b].add(nextNode);
                        }
                    }

                    Set<Integer> firstSet = setList.get(0);
                    int firstNode = firstSet.iterator().next();
                    while (!bList.isEmpty()) {
                        int b = bList.poll();
                        adj[firstNode].add(b);
                        adj[b] = new HashSet<>();
                        adj[b].add(firstNode);
                    }
                }

                // 得到了tree的adj，把所有边列出来
                List<int[]> edgeList = bfs(adj, n);
                for (int[] edge : edgeList) {
                    out.println(edge[0] + " " + edge[1]);
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

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
