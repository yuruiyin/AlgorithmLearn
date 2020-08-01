package round660_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private List<Integer>[] adj;
        private int[] hArr;
        private int[] pCountArr;
        private boolean isHappyOk = true;

        private long happyRec(int cur, boolean[] visited) {
            visited[cur] = true;
            List<Integer> nextList = adj[cur];

            long nextHappySum = 0;
            boolean isLeaf = true;
            for (Integer next : nextList) {
                if (visited[next]) {
                    continue;
                }

                isLeaf = false;
                nextHappySum += happyRec(next, visited);
            }

            if (!isLeaf && nextHappySum > hArr[cur]) {
                isHappyOk = false;
            }

            return nextHappySum + hArr[cur];
        }


        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 两种情况是NO
            // 1. 求解二元一次方程，x + y = sum, x - y = h1, 看x是否有整数解

            int t = in.nextInt();
            while ((t--) > 0) {
                // n座城市，m个人
                int n = in.nextInt();
                int m = in.nextInt();
                // p1 + p2 + p3 + .. +pn = m
                pCountArr = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    pCountArr[i] = in.nextInt();
                }

                hArr = new int[n + 1];
                for (int i = 0; i < n; i++) {
                    hArr[i + 1] = in.nextInt();
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

                if ((m + hArr[1]) % 2 == 1) {
                    out.println("NO");
                    continue;
                }

                int maxHappyCount = (m + hArr[0]) / 2;

                happyRec(1, new boolean[n + 1]);
                if (!isHappyOk) {
                    out.println("NO");
                    continue;
                }

                out.println("YES");
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
