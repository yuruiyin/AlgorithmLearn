package round676_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

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

                if (grid[0][1] == '0' && grid[1][0] == '0' && grid[n - 1][n - 2] == '1' && grid[n - 2][n - 1] == '1' ||
                        grid[0][1] == '1' && grid[1][0] == '1' && grid[n - 1][n - 2] == '0' && grid[n - 2][n - 1] == '0') {
                    out.println(0);
                    continue;
                }

                if (grid[0][1] == grid[1][0] && grid[n - 1][n - 2] == grid[n - 2][n - 1]) {
                    out.println(2);
                    out.println("1 2");
                    out.println("2 1");
                    continue;
                }

                if (grid[n - 1][n - 2] == grid[n - 2][n - 1]) {
                    char num = grid[n - 1][n - 2];
                    out.println(1);
                    if (grid[0][1] == num) {
                        out.println("1 2");
                    } else {
                        out.println("2 1");
                    }
                } else if (grid[0][1] == grid[1][0]) {
                    char num = grid[0][1];
                    out.println(1);
                    if (grid[n - 1][n - 2] == num) {
                        out.println((n) + " " + (n - 1));
                    } else {
                        out.println((n - 1) + " " + (n));
                    }
                } else {
                    out.println(2);
                    out.println((n) + " " + (n - 1));
                    grid[n - 1][n - 2] = grid[n - 2][n - 1];
                    char num = grid[n - 1][n - 2];
                    if (grid[0][1] == num) {
                        out.println("1 2");
                    } else {
                        out.println("2 1");
                    }
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
