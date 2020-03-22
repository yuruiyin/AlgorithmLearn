package AGC043;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class A {

    static class Task {

        class Node {
            int row;
            int col;
            int blackCount;
            Node(int row, int col, int blackCount) {
                this.row = row;
                this.col = col;
                this.blackCount = blackCount;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            int n = in.nextInt();
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = in.next().toCharArray();
            }

//            LinkedList<Node> queue = new LinkedList<>();
//            queue.add(new Node(0, 0, grid[0][0] == '#' ? 1 : 0));



            // 求所有路径中最少的"#"个数
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0] == '#' ? 1 : 0;
            for (int j = 1; j < n; j++) {
                dp[0][j] = grid[0][j] == '#' && grid[0][j-1] == '.' ? dp[0][j-1] + 1 : dp[0][j-1];
            }

            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] == '#' && grid[i-1][0] == '.' ? dp[i-1][0] + 1 : dp[i-1][0];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.min(
                            dp[i-1][j] + (grid[i][j] == '#' && grid[i-1][j] == '.' ? 1 : 0),
                            dp[i][j-1] + (grid[i][j] == '#' && grid[i][j-1] == '.' ? 1 : 0)
                    );
                }
            }

            out.println(dp[m-1][n-1]);
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
