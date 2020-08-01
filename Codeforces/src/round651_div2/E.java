package round651_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class E {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            char[] arr1 = in.next().toCharArray();
            char[] arr2 = in.next().toCharArray();

            int oneCount1 = 0;
            int oneCount2 = 0;
            for (int i = 0; i < n; i++) {
                if (arr1[i] == '1') {
                    oneCount1++;
                }

                if (arr2[i] == '1') {
                    oneCount2++;
                }
            }

            if (oneCount1 != oneCount2) {
                out.println(-1);
                return;
            }

            // 需要是相同的模式才可以移动
            List<Character> diffList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (arr1[i] != arr2[i]) {
                    diffList.add(arr1[i]);
                }
            }

            if (diffList.isEmpty()) {
                out.println(0);
                return;
            }

            int size = diffList.size();
            int ansCount = 0;
            int endZeroCount = 0;
            int endOneCount = 0;

            for (int i = 0; i < size; i++) {
                char num = diffList.get(i);
                if (num == '0') {
                    if (endOneCount > 0) {
                        endOneCount--;
                    } else {
                        ansCount++;
                    }
                    endZeroCount++;
                } else {
                    if (endZeroCount > 0) {
                        endZeroCount--;
                    } else {
                        ansCount++;
                    }
                    endOneCount++;
                }
            }

            out.println(ansCount);
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
