package inszva_group_test01;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class C {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            // 单调栈，寻找右侧第一个比当前运算大于或等于的数的位置
            int max = 0;
            Stack<Integer> indexStack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!indexStack.isEmpty() && arr[indexStack.peek()] <= arr[i]) {
                    indexStack.pop();
                }

                if (!indexStack.isEmpty()) {
                    max = Math.max(max, indexStack.peek() - i - 1);
                }
                indexStack.push(i);
            }

            indexStack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!indexStack.isEmpty() && arr[indexStack.peek()] <= arr[i]) {
                    indexStack.pop();
                }

                if (!indexStack.isEmpty()) {
                    max = Math.max(max, i - indexStack.peek() - 1);
                }
                indexStack.push(i);
            }

            int count = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i -1]) {
                    count++;
                    max = Math.max(max, count - 2);
                } else {
                    count = 1;
                }
            }

            out.println(Math.max(0, max));
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
