package global_round012;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 如果给出的是升序或者降序(1-n或者n-1)那么输出全1
            // 如果没有1，则输出全0
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                boolean[] visited = new boolean[n + 1];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    visited[arr[i]] = true;
                }

                int firstNotExist = n + 1;
                for (int i = 1; i <= n; i++) {
                    if (!visited[i]) {
                        firstNotExist = i;
                        break;
                    }
                }

                if (firstNotExist == 1) {
                    for (int i = 0; i < n; i++) {
                        out.print(0);
                    }
                    out.println();
                    continue;
                }

                int[] ansArr = new int[n];
                int fromL = -1;
                int maxInterval = 0;
                for (int i = 1; i < n - 1; ) {
                    if (arr[i] <= arr[i - 1] && arr[i] <= arr[i + 1]) {
                        if (fromL == -1) {
                            int lIdx = -1;
                            for (int l = i - 1; l >= 0; l--) {
                                if (arr[l] < arr[i]) {
                                    break;
                                }

                                lIdx = l;
                            }

                            int rIdx = -1;
                            for (int r = i + 1; r < n; r++) {
                                if (arr[r] < arr[i]) {
                                    break;
                                }
                                rIdx = r;
                            }

                            int count = rIdx - lIdx;
                            // [2, count]
                            maxInterval = Math.max(maxInterval, count);
                            fromL = lIdx - 1;
                            i = rIdx + 1;
                        } else {
                            int lIdx = fromL - 1;
                            for (int l = fromL; l >= 0; l--) {
                                if (arr[l] < arr[i]) {
                                    break;
                                }

                                lIdx = l;
                            }

                            int rIdx = -1;
                            for (int r = i + 1; r < n; r++) {
                                if (arr[r] < arr[i]) {
                                    break;
                                }
                                rIdx = r;
                            }

                            int count = rIdx - lIdx;
                            // [2, count]
                            maxInterval = Math.max(maxInterval, count);
                            fromL = lIdx - 1;
                            i = rIdx + 1;
                        }
                    } else {
                        i++;
                    }
                }

                if (firstNotExist == n + 1) {
                    ansArr[0] = 1;
                } else {
                    ansArr[0] = 0;
                }

                for (int i = maxInterval; i < n; i++) {
                    ansArr[i] = 1;
                }

                for (int i = 0; i <= n - firstNotExist; i++) {
                    ansArr[i] = 0;
                }

                for (int i = 0; i < n; i++) {
                    out.print(ansArr[i]);
                }
                out.println();
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
