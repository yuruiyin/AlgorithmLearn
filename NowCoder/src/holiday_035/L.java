package holiday_035;

import java.io.*;
import java.util.StringTokenizer;

public class L {

    static class Task {

        private int n;
        private char[][] grid;
        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};

        private void dfs(int row, int col, boolean[][] visited, char curC) {
            if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] != curC) {
                return;
            }

            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int nextRow = row + dx[i];
                int nextCol = col + dy[i];
                dfs(nextRow, nextCol, visited, curC);
            }
        }

        private void changeGrid() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'G') {
                        grid[i][j] = 'R';
                    }
                }
            }
        }

        private int getCount() {
            int count = 0;
            boolean[][] visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    count++;
                    dfs(i, j, visited, grid[i][j]);
                }
            }
            return count;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = in.next().toCharArray();
            }

            int humanCnt = getCount();
            changeGrid();
            int cowCount = getCount();
            out.println(humanCnt + " " + cowCount);
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
