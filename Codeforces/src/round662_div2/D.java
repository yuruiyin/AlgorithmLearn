package round662_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = in.next().toCharArray();
            }

            int[][] dp = new int[n][m];
            for (int i = 0; i < n; i++) {
                dp[i][0] = 1;
            }

            for (int j = 0; j < m; j++) {
                dp[0][j] = 1;
            }

            int[][] rightBottomCountArr = new int[n][m];
            int[][] leftBottomCountArr = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(rightBottomCountArr[i], 1);
                Arrays.fill(leftBottomCountArr[i], 1);
            }

            for (int i = 0; i < n; i++) {
                // j = 0, 第一列
                int count = 0;
                for (int k = 1; i + k < n && k < m; k++) {
                    if (grid[i + k][k] != grid[i][0]) {
                        break;
                    }

                    count++;
                }

                rightBottomCountArr[i][0] += count;
            }

            for (int j = 0; j < m; j++) {
                // 第一行
                int count = 0;
                for (int k = 1; j + k < m && k < n; k++) {
                    if (grid[k][j + k] != grid[0][j]) {
                        break;
                    }
                    count++;
                }

                rightBottomCountArr[0][j] += count;
            }

            // 求leftBottomCountArr 先单独处理第一行和最后一列
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int k = 1; i + k < n && k < m; k++) {
                    if (grid[i + k][m - 1 - k] != grid[i][m-1]) {
                        break;
                    }

                    count++;
                }

                leftBottomCountArr[i][m-1] += count;
            }

            for (int j = 0; j < m; j++) {
                // 第一行
                int count = 0;
                for (int k = 1; j - k >= 0 && k < n; k++) {
                    if (grid[k][j - k] != grid[0][j]) {
                        break;
                    }
                    count++;
                }

                leftBottomCountArr[0][j] += count;
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (grid[i][j] == grid[i-1][j-1]) {
                        rightBottomCountArr[i][j] = rightBottomCountArr[i-1][j-1] - 1;
                    } else {
                        int count = 0;
                        for (int k = 1; i + k < n && j + k < m; k++) {
                            if (grid[i + k][j + k] != grid[i][j]) {
                                break;
                            }
                            count++;
                        }
                        rightBottomCountArr[i][j] += count;
                    }

                    if (j == m - 1) {
                        continue;
                    }
                    if (grid[i][j] == grid[i-1][j+1]) {
                        leftBottomCountArr[i][j] = leftBottomCountArr[i-1][j+1] - 1;
                    } else {
                        int count = 0;
                        for (int k = 1; i + k < n && j - k >= 0; k++) {
                            if (grid[i + k][j - k] != grid[i][j]) {
                                break;
                            }
                            count++;
                        }
                        leftBottomCountArr[i][j] += count;
                    }
                }
            }

            long ans = n + m - 1;
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (grid[i][j] != grid[i][j-1] || grid[i][j] != grid[i-1][j]) {
                        dp[i][j] = 1;
                        ans++;
                        continue;
                    }

                    // 往上多check两个
                    int preCount = dp[i][j-1];
                    int offset;
                    int time = 0;
                    for (offset = preCount - 1; i + offset < n && i - offset >= 0; offset++) {
                        time++;
                        if (time > 2) {
                            break;
                        }

                        if (j + offset >= m) {
                            break;
                        }

                        // 这个for循环要优化
                        boolean isAllSame = grid[i - offset][j] == grid[i][j] && rightBottomCountArr[i - offset][j] >= offset + 1
                                && grid[i][j + offset] == grid[i][j] && leftBottomCountArr[i][j + offset] >= offset + 1;
                        if (!isAllSame) {
                            break;
                        }
                    }

                    dp[i][j] = offset;
                    ans += dp[i][j];
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
