package dp_contest;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {

    static class Task {

        // LCS，最长公共子序列 打印路径
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] arr1 = in.next().toCharArray();
            char[] arr2 = in.next().toCharArray();
            int len1 = arr1.length;
            int len2 = arr2.length;

            int[][] dp = new int[len1][len2];
            dp[0][0] = arr1[0] == arr2[0] ? 1: 0;

            // 第一行
            for (int j = 1; j < len2; j++) {
                dp[0][j] = arr1[0] == arr2[j] ? 1 : dp[0][j - 1];
            }

            // 第一列
            for (int i = 1; i < len1; i++) {
                dp[i][0] = arr1[i] == arr2[0] ? 1 : dp[i - 1][0];
            }

            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if (arr1[i] == arr2[j]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            // 打印路径
            StringBuilder sb = new StringBuilder();
            int i = len1 - 1;
            int j = len2 - 1;
            while (i >= 0 && j >= 0 && dp[i][j] > 0) {
                if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                    // 来自上方向
                    i--;
                } else if (j > 0 && dp[i][j] == dp[i][j - 1]) {
                    // 来自左方向
                    j--;
                } else {
                    sb.append(arr1[i]);
                    i--;
                    j--;
                }
            }

            out.println(sb.reverse());
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
