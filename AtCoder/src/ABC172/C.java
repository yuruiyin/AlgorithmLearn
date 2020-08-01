package ABC172;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private void calcPreSum(long[] preSumArr, int[] arr) {
            int n = arr.length;
            preSumArr[0] = arr[0];
            for (int i = 1; i < n; i++) {
                preSumArr[i] = preSumArr[i - 1] + arr[i];
            }
        }

        private int findLastSmallerOrEqual(long[] arr, long target) {
            int len = arr.length;
            int low = 0;
            int high = len - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                long midVal = arr[mid];
                if (midVal <= target) {
                    if (mid == len - 1 || arr[mid + 1] > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

        private long getMax(long[] preSumArr1, long[] preSumArr2, int k) {
            long ansMaxCount = 0;
            int m = preSumArr2.length;

            for (int j = 0; j < m; j++) {
                long preSum = preSumArr2[j];
                if (preSum > k) {
                    break;
                }

                long left = k - preSum;
                if (left <= 0) {
                    ansMaxCount = Math.max(ansMaxCount, j + 1);
                    break;
                }

                long lastSmallerIdx = findLastSmallerOrEqual(preSumArr1, left);
                ansMaxCount = Math.max(ansMaxCount, j + 1 + lastSmallerIdx + 1);
            }

            return ansMaxCount;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = in.nextInt();
            }

            for (int j = 0; j < m; j++) {
                arr2[j] = in.nextInt();
            }

            // 二分
            long[] preSumArr1 = new long[n];
            long[] preSumArr2 = new long[m];
            calcPreSum(preSumArr1, arr1);
            calcPreSum(preSumArr2, arr2);
            out.println(Math.max(getMax(preSumArr1, preSumArr2, k), getMax(preSumArr2, preSumArr1, k)));
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
