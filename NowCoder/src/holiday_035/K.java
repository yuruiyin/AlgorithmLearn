package holiday_035;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class K {

    static class Task {

        private long[] preSumArr;

        class Data {
            int g;
            int x;
            Data(int g, int x) {
                this.g = g;
                this.x = x;
            }
        }

        private void calcPreSumArr(Data[] datas, int n) {
            preSumArr = new long[n];
            preSumArr[0] = datas[0].g;
            for (int i = 1; i < n; i++) {
                preSumArr[i] = preSumArr[i-1] + datas[i].g;
            }
        }

        private int findFirstBiggerOrEqual(Data[] datas, int target) {
            int low = 0;
            int high = datas.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = datas[mid].x;
                if (midVal >= target) {
                    if (mid == 0 || datas[mid - 1].x < target) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        private int findLastSmallerOrEqual(Data[] datas, int target) {
            int n = datas.length;
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = datas[mid].x;
                if (midVal <= target) {
                    if (mid == n - 1 || datas[mid + 1].x > target) {
                        return mid;
                    }

                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            //二分
            int n = in.nextInt();
            int k = in.nextInt();
            Data[] datas = new Data[n];
            for (int i = 0; i < n; i++) {
                datas[i] = new Data(in.nextInt(), in.nextInt());
            }

            Arrays.sort(datas, Comparator.comparingInt(o -> o.x));
            int min = datas[0].x;
            int max = datas[n - 1].x;
            calcPreSumArr(datas, n);
            long ansMax = 0;
            for (int i = min; i <= max; i++) {
                int leftIndex = findFirstBiggerOrEqual(datas, i - k);
                int rightIndex = findLastSmallerOrEqual(datas, i + k);
                if (leftIndex > rightIndex) {
                    continue;
                }

                long amount = leftIndex == 0 ? preSumArr[rightIndex] : preSumArr[rightIndex] - preSumArr[leftIndex - 1];
                ansMax = Math.max(ansMax, amount);
            }

            out.println(ansMax);
        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
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
