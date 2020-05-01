package round635_div2;

import java.io.*;
import java.util.*;

public class C {

    static class Task {

        private List<Integer>[] adj;
        private int[] countArr;
        private int[] deepArr;
        private boolean[] visited;

        private int getCount(int cur, int level) {
            List<Integer> nextList = adj[cur];
            visited[cur] = true;
            int ansCount = 0;
            deepArr[cur] = level;
            for (Integer next: nextList) {
                if (visited[next]) {
                    continue;
                }
                ansCount += getCount(next, level + 1);
            }
            countArr[cur] = ansCount;
            return ansCount + 1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            adj = new ArrayList[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                if (adj[u] == null) {
                    adj[u] = new ArrayList<>();
                }
                adj[u].add(v);

                if (adj[v] == null) {
                    adj[v] = new ArrayList<>();
                }
                adj[v].add(u);
            }

            // 计算每个节点为根的子树的节点数,1为整棵树的根
            countArr = new int[n + 1];
            deepArr = new int[n + 1];
            visited = new boolean[n + 1];
            getCount(1, 0);

            // 按deep - count进行排序
            int[] weights = new int[n];
            for (int i = 1; i <= n; i++) {
                weights[i-1] = deepArr[i] - countArr[i];
            }

            sort(weights);
            long ans = 0;
            for (int i = n - 1; i > n - 1 - k; i--) {
                ans += weights[i];
            }
            out.println(ans);
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
