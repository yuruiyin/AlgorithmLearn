package educational_round092;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                int z = in.nextInt();

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                if (z == 0) {
                    long ans = 0;
                    for (int i = 0; i <= k; i++) {
                        ans += arr[i];
                    }
                    out.println(ans);
                    continue;
                }

                int[] preMaxSumIdxArr = new int[n];
                int[] preSumArr = new int[n];
                preSumArr[0] = arr[0];
                for (int i = 1; i <= k; i++) {
                    preSumArr[i] = preSumArr[i - 1] + arr[i];
                }

                int maxIdx = -1;
                int maxSum = 0;
                for (int i = 0; i < k; i++) {
                    int sum = arr[i] + arr[i + 1];
                    if (sum > maxSum) {
                        maxSum = sum;
                        maxIdx = i;
                        preMaxSumIdxArr[i] = maxIdx;
                    } else {
                        preMaxSumIdxArr[i] = preMaxSumIdxArr[i-1];
                    }
                }

                long ansMax = 0;
                for (int i = k - 1; i >= 0; i--) {
                    int leftCount = k - i - 1;
                    int tmpCount = Math.min(z, leftCount / 2);
                    int maxIndex = preMaxSumIdxArr[i];
                    long sum = preSumArr[i + 1] + tmpCount * (arr[maxIndex] + arr[maxIndex + 1]);
                    if (maxIndex == i && leftCount % 2 == 1 && z > tmpCount) {
                        sum += arr[maxIndex];
                    }
                    ansMax = Math.max(ansMax, sum);
                }

                out.println(ansMax);
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
