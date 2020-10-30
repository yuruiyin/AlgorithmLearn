package round678_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Result {
            long sum;
            long leafCount;
            long leafMax;
            Result(long sum, long leafCount, long leafMax) {
                this.sum = sum;
                this.leafCount = leafCount;
                this.leafMax = leafMax;
            }
        }

        private List<Integer>[] adj;
        private int n;
        private long[] arr;

        private Result dfs(int cur) {
            List<Integer> nextList = adj[cur];
            if (nextList == null) {
                return new Result(arr[cur], 1, arr[cur]);
            }

            Result result;
            long sum = arr[cur];
            long leafCount = 0;
            long leafMax = 0;
            for (int next : nextList) {
                Result nextRes = dfs(next);
                sum += nextRes.sum;
                leafCount += nextRes.leafCount;
                leafMax = Math.max(leafMax, nextRes.leafMax);
            }

            leafMax = Math.max(leafMax, sum / leafCount + (sum % leafCount == 0 ? 0 : 1));
            return new Result(sum, leafCount, leafMax);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.n = in.nextInt();
            this.adj = new ArrayList[n + 1];
            for (int i = 2; i <= n; i++) {
                int pi = in.nextInt();
                if (adj[pi] == null) {
                    adj[pi] = new ArrayList<>();
                }
                adj[pi].add(i);
            }

            arr = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = in.nextInt();
            }

            Result ans = dfs(1);
            out.print(ans.leafMax);
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
