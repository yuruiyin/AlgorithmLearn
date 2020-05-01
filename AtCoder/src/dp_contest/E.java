package dp_contest;

import java.io.*;
import java.util.*;

public class E {

    static class Task {

        class Data {
            int w;
            int v;
            Data(int w, int v) {
                this.w = w;
                this.v = v;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int w = in.nextInt();
            Data[] datas = new Data[n];
            for (int i = 0; i < n; i++) {
                datas[i] = new Data(in.nextInt(), in.nextInt());
            }

            // 思路：将最大化价值转化为最小化体积问题（即能达到某个价值所需要的最小体积）
            // 同时n = 100 v <= 1000，因此，最大价值就是1e5
            int maxV = 100005;
            long[] dp = new long[maxV + 1];
            Arrays.fill(dp, Long.MAX_VALUE - w);
            long ans = 0;
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                for (int j = maxV; j >= datas[i].v; j--) {
                    dp[j] = Math.min(dp[j], dp[j - datas[i].v] + datas[i].w);
                    if (dp[j] <= w) {
                        ans = Math.max(ans, j);
                    }
                }
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
