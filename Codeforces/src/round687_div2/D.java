package round687_div2;

import java.io.*;
import java.util.Arrays;
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

            if (n == 2) {
                out.println(-1);
                return;
            }

            long preSum = arr[0] + arr[1];
            boolean isOk = false;
            for (int i = 2; i < n; i++) {
                if (preSum > arr[i]) {
                    isOk = true;
                    break;
                }
                preSum += arr[i];
            }

            if (!isOk) {
                out.println(-1);
                return;
            }

            int ans = -1;
            for (int i = 0; i < n - 1; i++) {
                int xor = arr[i] ^ arr[i + 1];
                if (i == 0) {
                    if (xor > arr[i + 2]) {
                        ans = 1;
                        break;
                    }
                } else if (i == n - 2) {
                    if (xor < arr[i - 1]) {
                        ans = 1;
                        break;
                    }
                } else {
                    if (xor < arr[i - 1] || xor > arr[i + 2]) {
                        ans = 1;
                        break;
                    }
                }
            }

            if (ans == 1) {
                out.println(ans);
                return;
            }

            for (int i = 0; i < n - 2; i++) {
                int xor = arr[i] ^ arr[i + 1] ^ arr[i + 2];
                if (i == 0) {
                    if (xor > arr[i + 3]) {
                        ans = 2;
                        break;
                    }
                } else if (i == n - 3) {
                    if (xor < arr[i - 1]) {
                        ans = 2;
                        break;
                    }
                } else {
                    if (xor < arr[i - 1] || xor > arr[i + 3]) {
                        ans = 2;
                        break;
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
