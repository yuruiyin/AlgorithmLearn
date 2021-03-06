package problem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF455A {

    static class Task {

        class Data {
            long num;
            long count;
            Data(long num, long count) {
                this.num = num;
                this.count = count;
            }
        }

        private List<Data> list;
        private int size;
        private long[] memo;

        private long dp(int curIdx) {
            if (curIdx >= size) {
                return 0;
            }

            Data data = list.get(curIdx);
            if (curIdx == size - 1) {
                return data.num * data.count;
            }

            if (memo[curIdx] != -1) {
                return memo[curIdx];
            }

            Data nextData = list.get(curIdx + 1);

            if (data.num + 1 != nextData.num) {
                memo[curIdx] = data.num * data.count + dp(curIdx + 1);
                return memo[curIdx];
            }

            long ans = 0;
            ans = Math.max(ans, data.num * data.count + dp(curIdx + 2));
            if (curIdx == size - 2) {
                ans = Math.max(ans, nextData.num * nextData.count);
            } else {
                Data nextNextData = list.get(curIdx + 2);
                long tmpAns = nextData.num * nextData.count + (nextData.num + 1 == nextNextData.num ? dp(curIdx + 3) : dp(curIdx + 2));
                ans = Math.max(ans, tmpAns);
            }

            memo[curIdx] = ans;
            return memo[curIdx];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            list = new ArrayList<>();
            int[] countArr = new int[100001];
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                countArr[num]++;
            }

            for (int i = 1; i <= 100000; i++) {
                if (countArr[i] > 0) {
                    list.add(new Data(i, countArr[i]));
                }
            }

            this.size = list.size();
            memo = new long[size];
            Arrays.fill(memo, -1);
            out.println(dp(0));
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
