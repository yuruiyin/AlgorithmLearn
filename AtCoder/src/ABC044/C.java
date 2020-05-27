package ABC044;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private int[] arr;
        private int n;
        private int[] suffixSumArr;
        private Long[][][] memo;

        private long dp(int count, int sum, int idx) {
            if (count == 0 && sum == 0) {
                return 1;
            }

            if (idx == n) {
                return 0;
            }

            if (n - idx < count || suffixSumArr[idx] < sum || count <= 0 || sum < arr[idx]) {
                return 0;
            }

            if (memo[count][sum][idx] != null) {
                return memo[count][sum][idx];
            }

            // 不选或选
            long nonChooseRes = dp(count, sum, idx + 1);
            long chooseRes = dp(count - 1, sum - arr[idx], idx + 1);
            memo[count][sum][idx] = nonChooseRes + chooseRes;
            return memo[count][sum][idx];
        }

        private void calcSuffixSumArr() {
            suffixSumArr = new int[n];
            suffixSumArr[n - 1] = arr[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffixSumArr[i] = suffixSumArr[i + 1] + arr[i];
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            int a = in.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            sort(arr);
            calcSuffixSumArr();
            long ans = 0;
            memo = new Long[n + 1][n * a + 1][n + 1];
            for (int count = 1; count <= n; count++) {
                ans += dp(count, count * a, 0);
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
