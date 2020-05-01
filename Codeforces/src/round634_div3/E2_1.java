package round634_div3;

import java.io.*;
import java.util.*;

/**
 * 低手哥版本
 */
public class E2_1 {

    static class Task {

        private int[][] sum;
        private int[] a;
        private int n;

        int solve() {
            int ans = 0;
            for (int i = 1; i <= 200; i++)
                ans = Math.max(ans, sum[i][n]);
            int[] l = new int[205];
            int[] r = new int[205];
            for (int i = 1; i <= 200; i++) {
                l[i] = 0;
                r[i] = n + 1;
            }

            for (int x = 1; 2 * x < n; x++) {
                for (int i = 1; i <= 200; i++) {
                    boolean flag = false;
                    for (int j = l[i] + 1; j < r[i]; j++) {
                        if (a[j] == i) {
                            l[i] = j;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) l[i] = n + 1;
                    flag = false;
                    for (int j = r[i] - 1; j > l[i]; j--) {
                        if (a[j] == i) {
                            r[i] = j;
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) r[i] = 0;
                }
                for (int num = 1; num <= 200; num++) {
                    if (r[num] <= l[num]) continue;
                    for (int num2 = 1; num2 <= 200; num2++)
                        ans = Math.max(ans, x * 2 + sum[num2][r[num] - 1] - sum[num2][l[num]]);
                }
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                n = in.nextInt();
                a = new int[n + 1];
                sum = new int[205][n + 1];
                for (int i = 1; i <= n; i++) {
                    a[i] = in.nextInt();
                    for (int j = 1; j <= 200; j++)
                        sum[j][i] = sum[j][i - 1];
                    sum[a[i]][i] += 1;
                }

                out.println(solve());
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
