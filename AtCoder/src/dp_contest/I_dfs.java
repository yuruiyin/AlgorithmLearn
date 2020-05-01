package dp_contest;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class I_dfs {

    static class Task {

        private double[] arr;
        private int n;
        private Double[][] memo;
        private double[] suffixTail;

        private double dfs(int idx, int headCount) {
            if (idx == n) {
                return headCount == 0 ? 1 : 0;
            }

            if (headCount == 0) {
                return suffixTail[idx];
            }

            if (n - idx < headCount) {
                return 0.0;
            }

            if (memo[idx][headCount] != null) {
                return memo[idx][headCount];
            }

            double headRes = arr[idx] * dfs(idx + 1, headCount - 1);
            double tailRes = (1 - arr[idx]) * dfs(idx + 1, headCount);
            memo[idx][headCount] = headRes + tailRes;
            return memo[idx][headCount];
        }

        // 计算末尾反面的概率乘积
        private void calcSuffixTail() {
            suffixTail = new double[n];
            suffixTail[n - 1] = 1 - arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffixTail[i] = (1 - arr[i]) * suffixTail[i + 1];
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            arr = new double[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextDouble();
            }

            memo = new Double[n][n + 1];
            double ans = 0;
            calcSuffixTail();
            for (int headCount = n / 2 + 1; headCount <= n; headCount++) {
                ans += dfs(0, headCount);
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
