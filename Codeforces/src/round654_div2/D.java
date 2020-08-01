package round654_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private void print(int[][] arr, PrintWriter out) {
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    out.print(arr[i][j]);
                }
                out.println();
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();

                if (k % n == 0) {
                    out.println(0);
                    if (k == 0) {
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < n; j++) {
                                out.print(0);
                            }
                            out.println();
                        }
                    } else {
                        int[][] arr = new int[n][n];
                        int count = k / n;
                        for (int i = 0; i < n; i++) {
                            for (int j = i; j < i + count; j++) {
                                arr[i][j % n] = 1;
                            }
                        }

                        print(arr, out);
                    }
                } else {
                    out.println(2);
                    int mod = k % n;
                    int[][] arr = new int[n][n];
                    int count = k / n;
                    for (int i = 0; i < n; i++) {
                        int curCount = count + (i < mod ? 1 : 0);
                        for (int j = i; j < i + curCount; j++) {
                            arr[i][j % n] = 1;
                        }
                    }

                    print(arr, out);
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
