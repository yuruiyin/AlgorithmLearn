package AGC044;

import java.io.*;
import java.util.*;

public class A {

    static class Task {

        private long a;
        private long b;
        private long c;
        private long d;
        private Map<Long, Long> memoMap;
        private static final long MAX = (long) 1e18;

        private long dp(long n) {
            if (memoMap.containsKey(n)) {
                return memoMap.get(n);
            }

            long minRes = Long.MAX_VALUE;

            if (n % 2 == 0) {
                minRes = Math.min(minRes, dp(n / 2) + a);
                if (n / 2 <= MAX / d) {
                    minRes = Math.min(minRes, dp(n / 2) + n / 2 * d);
                }
            } else {
                minRes = Math.min(minRes, dp(n / 2) + a + d);
                minRes = Math.min(minRes, dp(n / 2 + 1) + a + d);
                if (n / 2 <= MAX / d) {
                    minRes = Math.min(minRes, dp(n / 2) + n / 2 * d + d);
                }
            }

            if (n % 3 == 0) {
                minRes = Math.min(minRes, dp(n / 3) + b);
                if (n * 2 / 3 <= MAX / d) {
                    minRes = Math.min(minRes, dp(n / 3) + n * 2 / 3 * d);
                }
            } else {
                long y = n % 3;
                minRes = Math.min(minRes, dp(n / 3) + b + y * d);
                y = 3 - y;
                minRes = Math.min(minRes, dp(n / 3 + 1) + b + y * d);
            }

            if (n % 5 == 0) {
                minRes = Math.min(minRes, dp(n / 5) + c);
                if (n * 4 / 5 <= MAX / d) {
                    minRes = Math.min(minRes, dp(n / 5) + n * 4 / 5 * d);
                }
            } else {
                long y = n % 5;
                minRes = Math.min(minRes, dp(n / 5) + c + y * d);
                y = 5 - y;
                minRes = Math.min(minRes, dp(n / 5 + 1) + c + y * d);
            }

            memoMap.put(n, minRes);
            return minRes;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long n = in.nextLong();
                a = in.nextLong();
                b = in.nextLong();
                c = in.nextLong();
                d = in.nextLong();

                memoMap = new HashMap<>();
                memoMap.put(1L, d);
                memoMap.put(0L, 0L);
                long ans = dp(n);
                out.println(ans);
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