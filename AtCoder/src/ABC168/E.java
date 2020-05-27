package ABC168;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

public class E {

    static class Task {

        private static final int MOD = 1000000007;

        class Data {
            long a;
            long b;

            Data(long a, long b) {
                this.a = a;
                this.b = b;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Data data = (Data) o;
                return a * data.b == b * data.a;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] pow2Arr = new long[n + 1];
            pow2Arr[0] = 1;
            for (int i = 1; i <= n; i++) {
                pow2Arr[i] = (pow2Arr[i - 1] * 2) % MOD;
            }

            long ans = n;
            Map<Double, Integer> countMap = new HashMap<>();
            int preZeroACount = 0;
            int diff = 0;
            for (int i = 0; i < n; i++) {
                long a = in.nextLong();
                long b = in.nextLong();
                if (i > 0) {
                    if (b == 0) {
                        if (a != 0) {
                            int leftCount = i - preZeroACount - diff;
                            ans = (ans + pow2Arr[leftCount] - 1) % MOD;
                        }
                    } else {
                        int count = countMap.getOrDefault(a * 1.0 / b, 0);
                        int leftCount = i - count - diff;
                        ans = (ans + pow2Arr[leftCount] - 1) % MOD;
                    }
                }

                if (a == 0 && b == 0) {
                    diff++;
                } else if (a == 0) {
                    preZeroACount++;
                } else {
                    double key = -b * 1.0 / a;
                    countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                }
            }

            out.println(ans);

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
