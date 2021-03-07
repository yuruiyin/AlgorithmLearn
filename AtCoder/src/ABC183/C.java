package ABC183;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private int n;
        private int[][] grid;

        private int dfs(int rowCount, int row, int k, boolean[] colVisited) {
            if (rowCount == n) {
                if (k == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }

            if (k <= 0) {
                return 0;
            }

            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (colVisited[j] || j == row || (rowCount != n - 1 && j == 0)) {
                    continue;
                }

                colVisited[j] = true;
                ans += dfs(rowCount + 1, j, k - grid[row][j], colVisited);
                colVisited[j] = false;
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.n = in.nextInt();
            int k = in.nextInt();
            grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            int ans = dfs(0, 0, k, new boolean[n]);
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
