package dp_contest;

import java.io.*;
import java.util.*;

public class E_tle {

    static class Task {

        class Data {
            int w;
            int v;
            Data(int w, int v) {
                this.w = w;
                this.v = v;
            }
        }

        private int n;
        private Data[] datas;
        private Map<Long, Long> memoMap;
        private long[] suffixWSum;
        private long[] suffixVSum;

        private long dp(int idx, int w) {
            if (w < 0) {
                return Long.MIN_VALUE;
            }

            if (idx == n) {
                return 0;
            }

            Data curData = datas[idx];

            if (curData.w > w) {
                return 0;
            }

            long key = (long) w * n + idx;
            if (memoMap.containsKey(key)) {
                return memoMap.get(key);
            }

            if (suffixWSum[idx] <= w) {
                memoMap.put(key, suffixVSum[idx]);
                return suffixVSum[idx];
            }

            long chooseRes = dp(idx + 1, w - curData.w) + curData.v;
            long nonChooseRes = dp(idx + 1, w);
            long res = Math.max(chooseRes, nonChooseRes);
            memoMap.put(key, res);
            return res;
        }

        private void calcSuffixSum() {
            suffixWSum = new long[n];
            suffixVSum = new long[n];
            suffixWSum[n - 1] = datas[n - 1].w;
            suffixVSum[n - 1] = datas[n - 1].v;
            for (int i = n - 2; i >= 0; i--) {
                suffixWSum[i] = suffixWSum[i + 1] + datas[i].w;
                suffixVSum[i] = suffixVSum[i + 1] + datas[i].v;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            int w = in.nextInt();
            datas = new Data[n];
            for (int i = 0; i < n; i++) {
                datas[i] = new Data(in.nextInt(), in.nextInt());
            }

            Arrays.sort(datas, Comparator.comparingInt(o -> o.w));
            memoMap = new HashMap<>();
            calcSuffixSum();
            out.println(dp(0, w));
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
