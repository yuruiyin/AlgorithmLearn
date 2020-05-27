package round644_div3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class H {

    static class Task {

        private long strToLong(String str) {
            char[] arr = str.toCharArray();
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                ans <<= 1L;
                ans += (arr[i] - '0');
            }
            return ans;
        }

        private String getAns(String str, int m) {
            StringBuilder sb = new StringBuilder(str);
            int len = str.length();
            if (m == len) {
                return str;
            }
            StringBuilder zeroSb = new StringBuilder("0".repeat(m - len));
            return zeroSb.append(sb).toString();
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long m = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = strToLong(in.next());
                }

                sort(arr);

                long totalCount = (1L << m) - n;
                long preRemovedNum = -1;
                long curCount = 0;
                long ans = -1;
                for (int i = 0; i < n; i++) {
                    long curRemovedNum = arr[i];
                    long newCount = curCount + curRemovedNum - preRemovedNum - 1;
                    if (totalCount % 2 == 0) {
                        if (newCount >= totalCount / 2) {
                            ans = preRemovedNum + totalCount / 2 - curCount;
                            break;
                        }
                    } else {
                        if (newCount >= (totalCount + 1) / 2) {
                            ans = preRemovedNum + (totalCount + 1) / 2 - curCount;
                            break;
                        }
                    }

                    preRemovedNum = curRemovedNum;
                    curCount = newCount;
                }

                if (ans == -1) {
                    if (totalCount % 2 == 0) {
                        ans = preRemovedNum + totalCount / 2 - curCount;
                    } else {
                        ans = preRemovedNum + (totalCount + 1) / 2 - curCount;
                    }
                }

                String ansStr = Long.toBinaryString(ans);
//                System.out.println(ansStr);
                out.println(getAns(ansStr, (int) m));
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
