package global_round012;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[][] grid = new char[n][n];
                for (int i = 0; i < n; i++) {
                    grid[i] = in.next().toCharArray();
                }

                for (int i = 1; i < n - 1; i++) {
                    for (int j = 1; j < n - 1; j++) {
                        if (grid[i][j] == 'X' && grid[i][j-1] == 'X' && grid[i-1][j] == 'X' &&
                                grid[i+1][j] == 'X' && grid[i][j + 1] == 'X') {
                            grid[i][j] = 'O';
                        }
                    }
                }

                for (int i = 1; i < n - 1; i++) {
                    for (int j = 0; j < n - 2; j++) {
                        if (grid[i][j] == 'X' && grid[i][j+1] == 'X' && grid[i][j+2] == 'X' &&
                                grid[i+1][j] == 'X' && grid[i-1][j] == 'X') {
                            grid[i][j] = 'O';
                        }
                    }
                }

                for (int i = 1; i < n - 1; i++) {
                    for (int j = 2; j < n; j++) {
                        if (grid[i][j] == 'X' && grid[i][j-1] == 'X' && grid[i][j-2] == 'X' &&
                                grid[i+1][j] == 'X' && grid[i-1][j] == 'X') {
                            grid[i][j] = 'O';
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    if (i == 0) {
                        for (int j = 2; j < n; j++) {
                            if (grid[i][j] == 'X' && grid[i][j-1] == 'X' && grid[i][j-2] == 'X') {
                                boolean isChanged = false;
                                int jj;
                                for (jj = j; jj >= j - 2; jj--) {
                                    if (grid[i+1][jj] == 'X' && grid[i + 2][jj] == 'X') {
                                        isChanged = true;
                                        break;
                                    }
                                }

                                if (!isChanged) {
                                    grid[i][j] = 'O';
                                } else {
                                    if (j < n - 1 && grid[i][j+1] == 'X' && jj == j - 2) {
                                        grid[i][j] = 'O';
                                    } else {
                                        grid[i][jj] = 'O';
                                    }
                                }
                            }
                        }
                    } else if (i == n - 1) {
                        for (int j = 0; j < n; j++) {
                            if (grid[i][j] != 'X') {
                                continue;
                            }

                            if (i >= 2 && grid[i-1][j] == 'X' && grid[i-2][j] == 'X') {
                                grid[i][j] = 'O';
                            }

                            if (j >= 2 && grid[i][j] == 'X' && grid[i][j-1] == 'X' && grid[i][j-2] == 'X') {
                                grid[i][j] = 'O';
                            }
                        }
                    } else {
                        for (int j = 0; j < n; j++) {
                            if (grid[i][j] != 'X') {
                                continue;
                            }

                            if (i >= 2 && grid[i-1][j] == 'X' && grid[i-2][j] == 'X') {
                                grid[i][j] = 'O';
                            }

//                            if (grid[i][j] == 'X' &&grid[i - 1][j] == 'X' && grid[i+1][j] == 'X') {
//                                grid[i][j] = 'O';
//                            }

                            if (j >= 2 && grid[i][j] == 'X' && grid[i][j-1] == 'X' && grid[i][j-2] == 'X') {
                                if (j < n - 1 && grid[i][j+1] == 'X') {
                                    grid[i][j] = 'O';
                                    continue;
                                }

                                if (i + 1 < n && i + 2 < n) {
                                    boolean isChanged = false;
                                    int jj;
                                    for (jj = j; jj >= j - 2; jj--) {
                                        if (grid[i+1][jj] == 'X' && grid[i + 2][jj] == 'X') {
                                            isChanged = true;
                                            break;
                                        }
                                    }

                                    if (!isChanged) {
                                        grid[i][j] = 'O';
                                    } else {
                                        if (j < n - 1 && grid[i][j+1] == 'X' && jj == j - 2) {
                                            grid[i][j] = 'O';
                                        } else {
                                            grid[i][jj] = 'O';
                                        }
                                    }
                                } else {
                                    grid[i][j] = 'O';
                                }

                            }
                        }
                    }

                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(grid[i][j]);
                    }
                    out.println();
                }
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

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
