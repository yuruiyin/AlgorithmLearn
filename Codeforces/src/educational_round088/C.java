package educational_round088;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.nextInt();
            while ((T--) > 0) {
                long h = in.nextLong();
                long c = in.nextLong();
                long t = in.nextLong();

                if (h == t) {
                    out.println(1);
                    continue;
                }

                if (2 * t <= (h + c)) {
                    out.println(2);
                    continue;
                }

                long low = 0;
                long high = (long) 1e9;

                while (low < high - 1) {
                    long mid = low + (high - low) / 2;
                    if ((mid + 1) * h + mid * c <= (2 * mid + 1) * t) {
                        high = mid;
                    } else {
                        low = mid;
                    }
                }

                long absLow = Math.abs(((low + 1) * h + low * c) * (2 * high + 1) - t * (2 * low + 1) * (2 * high + 1));
                long absHigh = Math.abs(((high + 1) * h + high * c) * (2 * low + 1) - t * (2 * low + 1) * (2 * high + 1));

                if (absLow <= absHigh) {
                    out.println(2 * low + 1);
                } else {
                    out.println(2 * high + 1);
                }
//
//                if (((low + 1) * h + low * c) * (2 * high + 1) + ((high + 1) * h + high * c) * (2 * low + 1) <=
//                        2 * t * (2 * low + 1) * (2 * high + 1)) {
//                    out.println(2 * low + 1);
//                } else {
//                    out.println(2 * high + 1);
//                }
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
