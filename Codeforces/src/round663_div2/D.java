package round663_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private int getOneCount(char[][] grid, int r, int c) {
            int oneCount = 0;
            for (int i = r - 1; i <= r; i++) {
                for (int j = c - 1; j <= c; j++) {
                    oneCount += (grid[i][j] - '0');
                }
            }

            return oneCount;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                grid[i] = in.next().toCharArray();
            }

            if (n >= 4 && m >= 4) {
                out.println(-1);
                return;
            }

            if (n == 1 || m == 1) {
                out.println(0);
                return;
            }

            if (n == 2) {
                long ans = 0;
                for (int j = 1; j < m - 1; j++) {
                    int leftOneCount = getOneCount(grid, 1, j);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, 1, j + 1);
                        if (rightOneCount % 2 == 1) {
                            grid[1][j-1] = grid[1][j - 1] == '0' ? '1' : '0';
                        } else {
                            grid[1][j] = grid[1][j] == '0' ? '1' : '0';
                        }
                        ans++;
                    }
                }

                int lastOneCount = getOneCount(grid, 1, m -1);
                if (lastOneCount % 2 == 0) {
                    ans++;
                }

                out.println(ans);
                return;
            }

            if (m == 2) {
                long ans = 0;
                for (int i = 1; i < n - 1; i++) {
                    int leftOneCount = getOneCount(grid, i, 1);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, i + 1, 1);
                        if (rightOneCount % 2 == 1) {
                            grid[i-1][1] = grid[i-1][1] == '0' ? '1' : '0';
                        } else {
                            grid[i][1] = grid[i][1] == '0' ? '1' : '0';
                        }
                        ans++;
                    }
                }

                int lastOneCount = getOneCount(grid, n - 1, 1);
                if (lastOneCount % 2 == 0) {
                    ans++;
                }

                out.println(ans);
                return;
            }

            if (n == 3) {
                long ans = 0;
                for (int j = 1; j < m - 1; j++) {
                    int leftOneCount = getOneCount(grid, 1, j);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, 1, j + 1);
                        int lbOneCount = getOneCount(grid, 2, j);
                        int rbOneCount = getOneCount(grid, 2, j + 1);
                        if (rightOneCount % 2 == 1) {
                            if (lbOneCount % 2 == 1) {
                                grid[0][j-1] = grid[0][j - 1] == '0' ? '1' : '0';
                            } else {
                                grid[1][j-1] = grid[1][j - 1] == '0' ? '1' : '0';
                            }
                        } else {
                            if (rbOneCount % 2 == 1) {
                                grid[0][j] = grid[0][j] == '0' ? '1' : '0';
                            } else {
                                grid[1][j] = grid[1][j] == '0' ? '1' : '0';
                            }
                        }
                        ans++;
                    }
                }

                int lastOneCount = getOneCount(grid, 1, m -1);
                if (lastOneCount % 2 == 0) {
                    ans++;
                }

                for (int j = 1; j < m - 1; j++) {
                    int leftOneCount = getOneCount(grid, 2, j);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, 2, j + 1);
                        if (rightOneCount % 2 == 1) {
                            grid[2][j-1] = grid[2][j - 1] == '0' ? '1' : '0';
                        } else {
                            grid[2][j] = grid[2][j] == '0' ? '1' : '0';
                        }
                        ans++;
                    }
                }

                int lastOneCount1 = getOneCount(grid, 2, m -1);
                if (lastOneCount1 % 2 == 0) {
                    ans++;
                }

                out.println(ans);
                return;
            }

            if (m == 3) {
                long ans = 0;
                for (int i = 1; i < n - 1; i++) {
                    int leftOneCount = getOneCount(grid, i, 1);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, i + 1, 1);
                        int lbOneCount = getOneCount(grid, i, 2);
                        int rbOneCount = getOneCount(grid, i + 1, 2);
                        if (rightOneCount % 2 == 1) {
                            if (lbOneCount % 2 == 1) {
                                grid[i - 1][0] = grid[i - 1][0] == '0' ? '1' : '0';
                            } else {
                                grid[i - 1][1] = grid[i - 1][1] == '0' ? '1' : '0';
                            }
                        } else {
                            if (rbOneCount % 2 == 1) {
                                grid[i][0] = grid[i][0] == '0' ? '1' : '0';
                            } else {
                                grid[i][1] = grid[i][1] == '0' ? '1' : '0';
                            }
                        }
                        ans++;
                    }
                }

                int lastOneCount = getOneCount(grid, n - 1, 1);
                if (lastOneCount % 2 == 0) {
                    ans++;
                }

                for (int i = 1; i < n - 1; i++) {
                    int leftOneCount = getOneCount(grid, i, 2);
                    if (leftOneCount % 2 == 1) {
                        continue;
                    } else {
                        int rightOneCount = getOneCount(grid, i + 1, 2);
                        if (rightOneCount % 2 == 1) {
                            grid[i-1][2] = grid[i-1][2] == '0' ? '1' : '0';
                        } else {
                            grid[i][2] = grid[i][2] == '0' ? '1' : '0';
                        }
                        ans++;
                    }
                }

                int lastOneCount1 = getOneCount(grid, n - 1, 2);
                if (lastOneCount1 % 2 == 0) {
                    ans++;
                }

                out.println(ans);
                return;
            }
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
