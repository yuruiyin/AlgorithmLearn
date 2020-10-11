package ABC174;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static class Task {

        private boolean isOk(int[] arr, int k, int target) {
            int count = 0;
            for (int num : arr) {
                int tmp = num / target + ((num % target) != 0 ? 1 : 0);
                count += (tmp - 1);
            }
            return count <= k;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 二分
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            int max = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                max = Math.max(max, arr[i]);
            }

            int low = 1;
            int high = max;
            long ans = max;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (isOk(arr, k, mid)) {
                    ans = Math.min(ans, mid);
                    high = mid - 1;
                } else {
                    low = mid + 1;
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
