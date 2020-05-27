package ABC167;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private static final int MAX = (int) 1e7;

        private int[] priceArr;
        private int[][] grid;
        private int n;
        private int m;
        private int x;

        private boolean isOk(int[] tmpArr, int x) {
            for (int i = 0; i < m; i++) {
                if (tmpArr[i] < x) {
                    return false;
                }
            }
            return true;
        }

        // 选择一些书，让每个技能都>=x
        private int dp(int idx, int[] tmpArr) {
            if (idx == n) {
                return isOk(tmpArr, x) ? 0 : MAX;
            }

            int[] newArr = Arrays.copyOf(tmpArr, m);
            for (int j = 0; j < m; j++) {
                newArr[j] += grid[idx][j];
            }

            int chooseRes = dp(idx + 1, newArr) + priceArr[idx];
            int nonChooseRes = dp(idx + 1, tmpArr);
            return Math.min(chooseRes, nonChooseRes);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            m = in.nextInt();
            x = in.nextInt();
            priceArr = new int[n];
            grid = new int[n][m];
            for (int i = 0; i < n; i++) {
                priceArr[i] = in.nextInt();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }

            int ans = dp(0, new int[m]);
            out.println(ans >= MAX ? -1 : ans);
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
