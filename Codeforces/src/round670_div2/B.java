package round670_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                sort(arr);

                if (n == 5) {
                    long ans = 1;
                    for (int i = 0; i < n; i++) {
                        ans *= arr[i];
                    }
                    out.println(ans);
                    continue;
                }

                if (arr[n - 1] <= 0) {
                    // 没有正数
                    long ans = 1;
                    for (int i = n - 1; i >= n - 5; i--) {
                        ans *= arr[i];
                    }
                    out.println(ans);
                    continue;
                }

                int lastNegativeIdx = -1;
                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 0) {
                        break;
                    }

                    lastNegativeIdx = i;
                }

                long ansMax = 0;
                long positiveSum = 1;
                for (int i = n - 1; i > Math.max(n - 6, lastNegativeIdx); i--) {
                    int positiveCount = n - i;
                    positiveSum *= arr[i];
                    long sum = positiveSum;
                    for (int j = 0; j < 5 - positiveCount; j++) {
                        sum *= arr[j];
                    }

                    ansMax = Math.max(ansMax, sum);
                }

                out.println(ansMax);
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
