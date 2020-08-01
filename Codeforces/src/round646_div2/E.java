package round646_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    static class Task {

        class Node {
            long a;
            int b;
            int c;

            Node(long a, int b, int c) {
                this.a = a;
                this.b = b;
                this.c = c;
            }
        }

        private Node[] nodes;
        private List<Integer>[] adj;
        private int[][] countArr;

        private int[] dfs(int cur, boolean[] visited) {
            Node curNode = nodes[cur];
            visited[cur] = true;
            int[] ans = new int[2];
            if (curNode.b != curNode.c) {
                ans[curNode.b]++;
            }

            for (Integer next: adj[cur]) {
                if (visited[next]) {
                    continue;
                }

                int[] res = dfs(next, visited);
                ans[0] += res[0];
                ans[1] += res[1];
            }

            countArr[cur] = ans;
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 贪心
            int n = in.nextInt();
            int oldDigitOneCount = 0;
            int newDigitOneCount = 0;
            nodes = new Node[n + 1];
            for (int i = 0; i < n; i++) {
                long a = in.nextLong();
                int b = in.nextInt();
                int c = in.nextInt();
                nodes[i + 1] = new Node(a, b, c);
                if (b == 1) {
                    oldDigitOneCount++;
                }

                if (c == 1) {
                    newDigitOneCount++;
                }
            }

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

            if (oldDigitOneCount != newDigitOneCount) {
                out.println(-1);
                return;
            }

            // 贪心
            countArr = new int[n + 1][2];
            dfs(1, new boolean[n + 1]);

            // TODO
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
