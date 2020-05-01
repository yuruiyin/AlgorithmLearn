package round633_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static class Task {

        public long fib(long n) {
            if (n <= 1) return n;
            double sqrt5 = Math.sqrt(5);
            double x1 = (1 + sqrt5) / 2;
            double x2 = (1 - sqrt5) / 2;
            return (long) ((Math.pow(x1, n) - Math.pow(x2, n)) / sqrt5);
        }

        // 每三项的第一个数字1 4 5 9 14 23 37
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long n = in.nextLong();
                long first = 1;
                long second = 4;
                long index = (n - 1) / 3;
                long mod = (n - 1) % 3;

                if (index == 0) {
                    out.println(first * (mod + 1));
                    continue;
                }

                if (index == 1) {
                    out.println(second * (mod + 1));
                    continue;
                }

                long ansFirst = fib(index - 1) * first + fib(index) * second;
                out.println(ansFirst * (mod + 1));
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
