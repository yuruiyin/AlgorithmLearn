package round645_div2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private int findFirstBiggerOrEqual(long[] arr, long target) {
            int low = 0;
            int high = arr.length - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target <= arr[mid]) {
                    if (mid == 0 || target > arr[mid - 1]) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        private long getSumFrom1ToN(long n) {
            return n * (n + 1) / 2;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long x = in.nextLong();
            long[] arr = new long[2 * n];
            long maxD = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
                maxD = Math.max(maxD, arr[i]);
            }

            // double数组
            for (int i = 0; i < n; i++) {
                arr[i + n] = arr[i];
            }

            n *= 2;

            if (x <= maxD) {
                long ans = getSumFrom1ToN(maxD) - getSumFrom1ToN(maxD - x);
                out.println(ans);
                return;
            }

            long[] preSumArr = new long[n];
            preSumArr[0] = arr[0];
            for (int i = 1; i < n; i++) {
                preSumArr[i] = preSumArr[i - 1] + arr[i];
            }

            long[] preValueArr = new long[n]; // 每个月的值为1 + 2 + 3 + 。。。 + di
            preValueArr[0] = getSumFrom1ToN(arr[0]);
            for (int i = 1; i < n; i++) {
                preValueArr[i] = preValueArr[i-1] + getSumFrom1ToN(arr[i]);
            }

            long ansMax = 0;
            for (int i = 0; i < n; i++) {
                long preSum = preSumArr[i];
                if (preSum < x) {
                    continue;
                }

                long diff = preSum - x;
                // 二分
                int firstBiggerOrEqualIdx = findFirstBiggerOrEqual(preSumArr, diff);
                long monthDayCount = arr[firstBiggerOrEqualIdx];
                long leftPreSum = preSumArr[firstBiggerOrEqualIdx];
                long leftRemainDays = x - (preSum - leftPreSum);
                long res = preValueArr[i] - preValueArr[firstBiggerOrEqualIdx] +
                        getSumFrom1ToN(monthDayCount) - getSumFrom1ToN(monthDayCount - leftRemainDays);
                ansMax = Math.max(ansMax, res);
            }

            out.println(ansMax);
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
