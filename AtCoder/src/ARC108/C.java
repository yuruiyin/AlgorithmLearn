package ARC108;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private static final long MAX = 100001;

        private List<Integer>[] adj;
        private Map<Long, Integer> weightMap;
        private int[] ansArr;

        private void dfs(int cur, boolean[] visited) {
            visited[cur] = true;
            List<Integer> nextList = adj[cur];
            for (int next : nextList) {
                if (visited[next]) {
                    continue;
                }

                int c = weightMap.get(cur * MAX + next);

                if (ansArr[cur] == c) {
                    ansArr[next] = c == 1 ? 2 : 1;
                } else {
                    ansArr[next] = c;
                }

                dfs(next, visited);
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            adj = new ArrayList[n + 1];
            weightMap = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int c = in.nextInt();

                if (adj[u] == null) {
                    adj[u] = new ArrayList<>();
                }
                adj[u].add(v);

                if (adj[v] == null) {
                    adj[v] = new ArrayList<>();
                }
                adj[v].add(u);

                weightMap.put(u * MAX + v, c);
                weightMap.put(v * MAX + u, c);
            }

            ansArr = new int[n + 1];
            ansArr[1] = 1;
            dfs(1, new boolean[n + 1]);
            for (int i = 1; i<= n; i++) {
                out.println(ansArr[i]);
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
