package ABC168;

import java.io.*;
import java.util.*;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 0; i < m; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                if (adj[v1] == null) {
                    adj[v1] = new ArrayList<>();
                }

                adj[v1].add(v2);

                if (adj[v2] == null) {
                    adj[v2] = new ArrayList<>();
                }

                adj[v2].add(v1);
            }

            int[] ansArr = new int[n + 1];
            // bfs
            boolean[] visited = new boolean[n + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(1);
            visited[1] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    List<Integer> nextList = adj[cur];
                    for (Integer next : nextList) {
                        if (visited[next]) {
                            continue;
                        }

                        ansArr[next] = cur;
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            boolean isOk = true;
            for (int i = 2; i <= n; i++) {
                if (ansArr[i] == 0) {
                    isOk = false;
                    break;
                }
            }

            if (!isOk) {
                out.println("No");
            } else {
                out.println("Yes");
                for (int i = 2; i <= n; i++) {
                    out.println(ansArr[i]);
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
