package global_round021;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    // 注意不要使用System.out.println
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long m = in.nextInt();
                long[] a = new long[n];
                for (int i = 0; i < n; i++) {
                    a[i] = in.nextInt();
                }
                int k = in.nextInt();
                long[] b = new long[k];
                for (int i = 0; i < k; i++) {
                    b[i] = in.nextInt();
                }

                int i, j;
                long sameCount = 1;
                boolean isOk = true;
                for (i = 0, j = 0; i < n && j < k; j++) {
                    if (a[i] == b[j]) {
                        if (sameCount > 1) {
                            sameCount--;
                        } else {
                            i++;
                        }
                    } else if (a[i] < b[j]) {
                        if (b[j] % a[i] != 0 || (b[j] / a[i]) % m != 0) {
                            isOk = false;
                            break;
                        }
                        // 需要先考虑sameCount
                        long minCount = Math.min(sameCount, m);
                        long left = b[j] - minCount * a[i];
                        sameCount -= minCount;
                        if (sameCount > 0) {
                            // 说明m比较小，当前a[i]有很多
                            continue;
                        }
                        // 需要借助后面的拆解
                        // a[i] 的samecount不够
                        long sum = 0;
                        int nextI = i + 1;
                        for (int ii = i + 1; ii < n; ii++) {
                            if (a[ii] != a[i] && (a[ii] % m != 0 || (a[ii] / m) % a[i] != 0)) {
                                isOk = false;
                                break;
                            }
                            sum += a[ii];
                            if (sum == left) {
                                nextI = ii + 1;
                                sameCount = 1;
                                break;
                            } else if (sum > left) {
                                nextI = ii;
                                a[nextI] = a[i];
                                if ((sum - left) % a[nextI] != 0) {
                                    isOk = false;
                                    break;
                                }
                                sameCount = (sum - left) / a[nextI];
                                break;
                            }
                        }
                        i = nextI;
                    } else {
                        // a[i] > b[j]
                        if (a[i] % b[j] != 0 || a[i] % m != 0) {
                            isOk = false;
                            break;
                        }

                        sameCount = a[i] / b[j] - 1;
                        a[i] = b[j];
                    }
                    if (!isOk) {
                        break;
                    }
                }

                out.println(isOk ? "Yes" : "No");
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
