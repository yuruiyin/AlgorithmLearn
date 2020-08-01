package round646_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                String str = in.next();
                char[] arr = str.toCharArray();
                int len = arr.length;
                int totalOneCount = 0;
                for (int i = 0; i < len; i++) {
                    if (arr[i] == '1') {
                        totalOneCount++;
                    }
                }

                int totalZeroCount = len - totalOneCount;

                int[] preOneCountArr = new int[len];
                preOneCountArr[0] = arr[0] == '1' ? 1 : 0;
                for (int i = 1; i < len; i++) {
                    preOneCountArr[i] = preOneCountArr[i - 1] + (arr[i] == '1' ? 1 : 0);
                }

                int ansMin = Math.min(totalOneCount, len - totalOneCount);
                // 左半0，右半1
                for (int i = 0; i < len; i++) {
                    int leftOneCount = preOneCountArr[i];
                    int rightZeroCount = totalZeroCount - (i + 1 - leftOneCount);
                    ansMin = Math.min(ansMin, leftOneCount + rightZeroCount);
                }

                // 左1， 右半0
                for (int i = 0; i < len; i++) {
                    int leftZeroCount = i + 1 - preOneCountArr[i];
                    int rightOneCount = totalOneCount - preOneCountArr[i];
                    ansMin = Math.min(ansMin, leftZeroCount + rightOneCount);
                }

                out.println(ansMin);
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
