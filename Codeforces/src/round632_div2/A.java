package round632_div2;

import java.io.*;
import java.util.StringTokenizer;

public class A {

    static class Task {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                boolean isFirstB = true;
                char[][] grid = new char[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (isFirstB) {
                            if (j % 2 == 0) {
                                grid[i][j] = 'B';
                            } else {
                                grid[i][j] = 'W';
                            }
                        } else {
                            if (j % 2 == 0) {
                                grid[i][j] = 'W';
                            } else {
                                grid[i][j] = 'B';
                            }
                        }
                    }
                    isFirstB = !isFirstB;
                }

                if ((n * m) % 2 == 0) {
                    if (m % 2 == 0) {
                        grid[0][m - 1] = 'B';
                    } else {
                        grid[n - 1][m-1] = 'B';
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        out.print(grid[i][j]);
                    }
                    out.println();
                }
            }
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
