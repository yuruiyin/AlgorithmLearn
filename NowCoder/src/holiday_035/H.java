package holiday_035;

import java.io.*;
import java.util.StringTokenizer;

public class H {

    static class Task {

        private long[][] preSumArr;

        private void calcPreSum(int[][] grid, int n) {
            preSumArr = new long[n][n];
            for (int i = 0; i < n; i++) {
                preSumArr[i][0] = grid[i][0];
                for (int j = 1; j < n; j++) {
                    preSumArr[i][j] = preSumArr[i][j-1] + grid[i][j];
                }
            }
        }

        // 思路：前缀和
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[][] grid = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            calcPreSum(grid, n);

            long ansMax = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int top = Math.max(0, i - k);
                    int bottom = Math.min(n - 1, i + k);
                    // 求每一行的区间和
                    long sum = 0;
                    for (int ii = top; ii <= bottom; ii++) {
                        int rowDiff = Math.abs(ii - i);
                        int left = Math.max(0, j - (k - rowDiff));
                        int right = Math.min(n - 1, j + (k - rowDiff));
                        sum += left == 0 ? preSumArr[ii][right] : preSumArr[ii][right] - preSumArr[ii][left - 1];
                    }

                    ansMax = Math.max(ansMax, sum);
                }
            }

            out.println(ansMax);
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
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
