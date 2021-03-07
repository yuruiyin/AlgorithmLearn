package ABC183;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static class Task {

        private static final int MOD = (int) (1e9 + 7);

        private int m;
        private int n;
        private char[][] grid;
        private long[][] memo;

        private long dp(int row, int col) {
            if (row == m - 1 && col == n - 1) {
                return 1;
            }

            if (memo[row][col] != -1) {
                return memo[row][col];
            }

            // 向右
            long ans = 0;
            for (int j = col + 1; j < n; j++) {
                if (grid[row][j] == '#') {
                    break;
                }

                ans = (ans + dp(row, j)) % MOD;
            }

            // 向下
            for (int i = row + 1; i < m; i++) {
                if (grid[i][col] == '#') {
                    break;
                }

                ans = (ans + dp(i, col)) % MOD;
            }

            // 右下
            for (int k = 1; row + k < m && col + k < n; k++) {
                if (grid[row + k][col + k] == '#') {
                    break;
                }

                ans = (ans + dp(row + k, col + k)) % MOD;
            }

            memo[row][col] = ans;
            return ans;
        }

        private long getValue(int n) {
            return n * (n + 1) / 2;
        }

        private int getAns() {
            long[][] dp = new long[m][n];
            int[][] leftCountArr = new int[m][n];
            int[][] topCountArr = new int[m][n];
            int[][] leftTopCountArr = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid[i][j] == '.' && grid[i][j - 1] == '.') {
                        leftCountArr[i][j] = leftCountArr[i][j - 1] + 1;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                for (int i = 1; i < m; i++) {
                    if (grid[i][j] == '.' && grid[i - 1][j] == '.') {
                        topCountArr[i][j] = topCountArr[i - 1][j] + 1;
                    }
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (grid[i][j] == '.' && grid[i - 1][j - 1] == '.') {
                        leftTopCountArr[i][j] = leftTopCountArr[i - 1][j - 1] + 1;
                    }
                }
            }

            dp[0][0] = 1;
            for (int i = 1; i < m; i++) {
                if (grid[i][0] == '.') {
                    dp[i][0] = getValue(topCountArr[i][0]) * dp[i - topCountArr[i][0]][0];
                }
            }

            for (int j = 1; j < n; j++) {
                if (grid[0][j] == '.') {
                    dp[0][j] = getValue(leftCountArr[0][j]) * dp[0][j - leftCountArr[0][j]];
                }
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = getValue(leftCountArr[i][j]) * dp[i][j - leftCountArr[i][j]] +
                            getValue(topCountArr[i][j]) * dp[i - topCountArr[i][j]][j] +
                            getValue(leftTopCountArr[i][j]) * dp[i - leftTopCountArr[i][j]][j - leftTopCountArr[i][j]];
                    dp[i][j] = dp[i][j] % MOD;
                }
            }

            return (int) dp[m - 1][n - 1];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.m = in.nextInt();
            this.n = in.nextInt();
            grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = in.next().toCharArray();
            }

//            memo = new long[m][n];
//            for (int i = 0; i < m; i++) {
//                Arrays.fill(memo[i], -1);
//            }
//            long ans = dp(0, 0);
            out.println(getAns() % MOD);
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
