package ABC044;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private long f(long b, long n) {
            if (n < b) {
                return n;
            }

            return f(b, n / b) + n % b;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long n = in.nextLong();
            long sum = in.nextLong();

            if (sum > n) {
                out.println(-1);
                return;
            }

            if (sum == n) {
                out.println(sum + 1);
                return;
            }

            int end = (int) Math.sqrt(n) + 1;

            for (int b = 2; b <= end; b++) {
                if (f(b, n) == sum) {
                    out.println(b);
                    return;
                }
            }

            // 当b > sqrt(n)，那么b进制的n就2位数，即
            // x0 + x1 * b = n
            // x0 + x1 = s
            // 得 x1 = (n - s) / x1 + 1
            // 同时x1一定是小于sqrt(n)，因此遍历x1即可
            for (int x1 = end ; x1 >= 1; x1--) {
                long b = (n - sum) / x1 + 1;
                if ((b - 1) * x1 != n - sum || x1 >= b) {
                    continue;
                }

                if (f(b, n) == sum) {
                    out.println(b);
                    return;
                }
            }


            out.println(-1);
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
