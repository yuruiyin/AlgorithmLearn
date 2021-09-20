package educational_round108;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] arr1 = new long[n];
            long[] arr2 = new long[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = in.nextLong();
            }

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += arr1[i] * arr2[i];
            }

//            long[] preSumArr = new long[n];
//            preSumArr[0] = arr1[0] * arr2[0];
//            for (int i = 1; i < n; i++) {
//                preSumArr[i] = preSumArr[i - 1] + arr1[i] * arr2[i];
//            }

            long ansMax = sum;
            // 升序对降序
            for (int i = 0; i < n; i++) {
                int start = i;
                int end = i;
                for (int j = i + 1; j < n; j++) {
                    if (!(arr1[j] >= arr1[j - 1] && arr2[j] <= arr2[j - 1])) {
                        break;
                    }
                    end = j;
                }

                long midSum1 = 0;
                long oldMidSum = 0;
                for (int k = start; k <= end; k++) {
                    midSum1 += arr2[k] * arr1[start + end - k];
                    oldMidSum += arr1[k] * arr2[k];
                }

                ansMax = Math.max(ansMax, sum - oldMidSum + midSum1);

                start = i;
                end = i;
                for (int j = i + 1; j < n; j++) {
                    if (!(arr1[j] <= arr1[j - 1] && arr2[j] >= arr2[j - 1])) {
                        break;
                    }
                    end = j;
                }

                midSum1 = 0;
                oldMidSum = 0;
                for (int k = start; k <= end; k++) {
                    midSum1 += arr2[k] * arr1[start + end - k];
                    oldMidSum += arr1[k] * arr2[k];
                }

                ansMax = Math.max(ansMax, sum - oldMidSum + midSum1);
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
