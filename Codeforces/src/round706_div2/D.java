package round706_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int maxCount = 1;

            int[] dp1 = new int[n];
            Arrays.fill(dp1, 1);
            for (int i = 1; i < n; i++) {
                if (arr[i] > arr[i - 1]) {
                    dp1[i] = dp1[i - 1] + 1;
                } else {
                    dp1[i] = 1;
                }
                maxCount = Math.max(maxCount, dp1[i]);
            }

            int[] dp2 = new int[n];
            Arrays.fill(dp2, 1);
            for (int i = n - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    dp2[i] = dp2[i + 1] + 1;
                } else {
                    dp2[i] = 1;
                }
                maxCount = Math.max(maxCount, dp2[i]);
            }

            List<Integer> maxIndexList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (dp1[i] == maxCount || dp2[i] == maxCount) {
                    maxIndexList.add(i);
                }
            }

            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                if (dp1[i] <= 1 || dp2[i] <= 1) {
                    continue;
                }

                if (dp1[i] % 2 == 0 && dp2[i] % 2 == 0) {
                    continue;
                } else if (dp1[i] % 2 == 1 && dp2[i] % 2 == 1) {
                    int oddMax = Math.max(dp1[i], dp2[i]);
                    int oddMin = Math.min(dp1[i], dp2[i]);
                    if (oddMax - 1 < oddMin && oddMax == maxCount && maxIndexList.size() == 1) {
                        ans++;
                    }
                } else {
                    int odd = dp1[i] % 2 == 1 ? dp1[i] : dp2[i];
                    int even = dp1[i] % 2 == 0 ? dp1[i] : dp2[i];
                    if (odd > even + 1 && even > 2 && odd == maxCount && maxIndexList.size() == 1) {
                        ans++;
                    }
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

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
