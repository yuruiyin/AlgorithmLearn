package APC2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private int[] memo;
        private int[] oneCountArr;

        private int rec(int value) {
            if (value == 0) {
                memo[0] = 0;
                return 0;
            }

            if (memo[value] != -1) {
                return memo[value];
            }

            memo[value] = 1 + rec(value % oneCountArr[value]);
            return memo[value];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt(); // 2 * 10^5
            char[] arr = in.next().toCharArray();
            int oneCount = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == '1') {
                    oneCount++;
                }
            }

            if (oneCount == 0) {
                // 全0, 全部输出1
                for (int i = 0; i < n; i++) {
                    out.println(1);
                }

                return;
            }

            memo = new int[oneCount + 2];
            oneCountArr = new int[oneCount + 2];
            for (int i = 0; i <= oneCount + 1; i++) {
                oneCountArr[i] = Integer.bitCount(i);
            }

            Arrays.fill(memo, -1);

            for (int i = 0; i <= oneCount + 1; i++) {
                rec(i);
            }

            if (oneCount == 1) {
                // 只有一个1，其中一个变成0，会出现全0的情况
                int[] add1modArr = new int[n];
                int cur = 1;
                int mod = oneCount + 1;
                for (int i = 0; i < n; i++) {
                    add1modArr[i] = cur % mod;
                    cur = (cur * 2) % mod;
                }

                int initVal = 1;

                for (int i = 0; i < n; i++) {
                    if (arr[i] == '1') {
                        out.println(0);
                    } else {
                        int ans = initVal + memo[add1modArr[n - i - 1]];
                        out.println(ans);
                    }
                }
                return;
            }

            // 计算2的n次方对oneCount - 1和oneCount + 1的模，循环节
            int[] add1modArr = new int[n];
            int cur = 1;
            int mod = oneCount + 1;
            for (int i = 0; i < n; i++) {
                add1modArr[i] = cur % mod;
                cur = (cur * 2) % mod;
            }

            int[] minus1modArr = new int[n];
            cur = 1;
            int mod1 = oneCount - 1;
            for (int i = 0; i < n; i++) {
                minus1modArr[i] = cur % mod1;
                cur = (cur * 2) % mod1;
            }

            cur = 0;
            int add1InitVal = cur;
            for (int i = 0; i < n; i++) {
                cur = (cur + (arr[i] - '0')) % (oneCount + 1);
                add1InitVal = cur;
                cur = (cur * 2) % (oneCount + 1);
            }

            cur = 0;
            int minus1InitVal = cur;
            for (int i = 0; i < n; i++) {
                cur = (cur + (arr[i] - '0')) % (oneCount - 1);
                minus1InitVal = cur;
                cur = (cur * 2) % (oneCount - 1);
            }


            for (int i = 0; i < n; i++) {
                if (arr[i] == '0') {
                    int ans = (add1InitVal + add1modArr[n - i - 1]) % (oneCount + 1);
                    out.println(memo[ans] + 1);
                } else {
                    int ans = (minus1InitVal - minus1modArr[n - i - 1] + oneCount - 1) % (oneCount - 1);
                    out.println(memo[ans] + 1);
                }
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
