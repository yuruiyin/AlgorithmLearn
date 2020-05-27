package round643_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    static class Task {

        private long getCost(int h, int[] hArr, int a, int r, int m) {
            long addCount = 0;
            long removeCount = 0;
            for (int num : hArr) {
                if (num < h) {
                    addCount += h - num;
                } else if (num > h) {
                    removeCount += num - h;
                }
            }

            int minMoveCost = Math.min(m, a + r);
            long minCount = Math.min(addCount, removeCount);
            long diffCount = Math.abs(addCount - removeCount);

            return minMoveCost * minCount + (addCount >= removeCount ? a * diffCount : r * diffCount);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int add = in.nextInt();
            int remove = in.nextInt();
            int move = in.nextInt();
            int[] hArr = new int[n];
            for (int i = 0; i < n; i++) {
                hArr[i] = in.nextInt();
            }

            if (n == 1) {
                out.println(0);
                return;
            }

            sort(hArr);

            // 三分，猜最终的高度，
            int low = hArr[0];
            int high = hArr[n - 1];
            while (high - low > 2) {
                int l = low + (high - low) / 3;
                int r = low + (high - low) * 2 / 3;
                long costL = getCost(l, hArr, add, remove, move);
                long costR = getCost(r, hArr, add, remove, move);
                if (costL < costR) {
                    high = r;
                } else {
                    low = l;
                }
            }

            long minCost = Long.MAX_VALUE;
            for (int i = low; i <= high; i++) {
                minCost = Math.min(minCost, getCost(i, hArr, add, remove, move));
            }

            out.println(minCost);
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
