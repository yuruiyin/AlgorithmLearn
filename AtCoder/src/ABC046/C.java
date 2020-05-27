package ABC046;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] arr1 = new long[n];
            long[] arr2 = new long[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = in.nextInt();
                arr2[i] = in.nextInt();
            }

            long pre1 = arr1[0];
            long pre2 = arr2[0];
            for (int i = 1; i < n; i++) {
                long cur1 = arr1[i];
                long cur2 = arr2[i];
                long count1 = pre1 / cur1 + (pre1 % cur1 != 0 ? 1 : 0);
                long count2 = pre2 / cur2 + (pre2 % cur2 != 0 ? 1 : 0);
                long maxCount = Math.max(count1, count2);

                for (long j = Math.max(1, maxCount - 2); j <= maxCount + 2; j++) {
                    if (cur1 * j >= pre1 && cur2 * j >= pre2) {
                        pre1 = cur1 * j;
                        pre2 = cur2 * j;
                        break;
                    }
                }
            }

            out.println(pre1 + pre2);
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
