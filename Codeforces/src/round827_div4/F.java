package round827_div4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class F {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int q = in.nextInt();
                long[] countArr1 = new long[26];
                long[] countArr2 = new long[26];
                countArr1[0] = 1;
                countArr2[0] = 1;
                while ((q--) > 0) {
                    int d = in.nextInt();
                    int k = in.nextInt();
                    String x = in.next();
                    for (char c : x.toCharArray()) {
                        if (d == 1) {
                            countArr1[c - 'a'] += k;
                        } else {
                            countArr2[c - 'a'] += k;
                        }
                    }

                    boolean isAllA2 = true;
                    for (int i = 1; i < 26; i++) {
                        if (countArr2[i] > 0) {
                            isAllA2 = false;
                            break;
                        }
                    }

                    if (!isAllA2) {
                        // 如果第二个字符串有一个不是a，那么它就一定可以比第一个字符串大
                        out.println("YES");
                        continue;
                    }

                    // 第二个字符串全是'a'
                    boolean isAllA1 = true;
                    for (int i = 1; i < 26; i++) {
                        if (countArr1[i] > 0) {
                            isAllA1 = false;
                            break;
                        }
                    }

                    if (isAllA1) {
                        // 第一个字符串全是a
                        if (countArr1[0] < countArr2[0]) {
                            out.println("YES");
                        } else {
                            out.println("NO");
                        }
                    } else {
                        out.println("NO");
                    }
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
