package dp_contest;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E_dfs {

    static class Task {

        class Data {
            int w;
            int v;
            Data(int w, int v) {
                this.w = w;
                this.v = v;
            }
        }

        private int n;
        private Data[] datas;
        private Long[][] memo;

        // 求总价值>=v的最小体积
        private long dp(int idx, int v) {
            if (v <= 0) {
                return 0;
            }

            if (idx == n) {
                return (long) 1e12;
            }

            if (memo[idx][v] != null) {
                return memo[idx][v];
            }

            long chooseRes = dp(idx + 1, v - datas[idx].v) + datas[idx].w;
            long nonChooseRes = dp(idx + 1, v);
            memo[idx][v] = Math.min(chooseRes, nonChooseRes);
            return memo[idx][v];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            int w = in.nextInt();
            datas = new Data[n];
            for (int i = 0; i < n; i++) {
                datas[i] = new Data(in.nextInt(), in.nextInt());
            }

            // 思路：将最大化价值转化为最小化体积问题（即能达到某个价值所需要的最小体积）
            // 同时n = 100 v <= 1000，因此，最大价值就是1e5
            // 这里使用二分猜最大价值，因为对于某个价值和mid，如果存在这个价值和>=mid的最小体积<=w，说明满足要求，那么最大价值可能比mid更大。
            // 即存在单调性
            int ans = 0;
            int low = 0;
            int high = 100000;
            memo = new Long[n][high + 1];
            while (low <= high) {
                int mid = (low + high) >>> 1;
                long minW = dp(0, mid);
                if (minW <= w) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
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
