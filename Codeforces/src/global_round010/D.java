package global_round010;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[] arr = in.next().toCharArray();

                int count = 1;
                int ans = 0;

                for (int i = 1; i < n; i++) {
                    if (arr[i] == arr[i - 1] && arr[i] == 'R') {
                        count++;
                        if (count == 3) {
                            if (arr[(i + 1) % n] == 'R') {
                                arr[i] = 'L';
                            } else {
                                arr[i-1] = 'L';
                            }
                        }
                    } else {
                        ans += count / 3;
                        count = 1;
                    }
                }

                ans += count / 3;

                count = 1;
                for (int i = n - 2; i >= 0; i--) {
                    if (arr[i] == arr[i + 1] && arr[i] == 'L') {
                        count++;
                        if (count == 3) {
                            if (arr[(i + n - 1) % n] == 'L') {
                                arr[i] = 'R';
                            } else {
                                arr[i + 1] = 'R';
                            }
                        }
                    } else {
                        ans += count / 3;
                        count = 1;
                    }
                }

                ans += count / 3;

                if (arr[n - 1] != arr[0]) {
                    out.println(ans);
                    continue;
                }

                int to = -1;
                for (int i = n - 2; i >= 0; i--) {
                    if (arr[i] != arr[i + 1]) {
                        to = i + 1;
                        break;
                    }
                }

                if (to == -1) {
                    // 都相等
                    ans += count % 3 != 0 ? 1 : 0;
                    out.println(ans);
                    continue;
                }

                int from = -1;
                for (int i = 1; i < n; i++) {
                    if (arr[i] != arr[i -1]) {
                        from = i - 1;
                        break;
                    }
                }

                int firstLastCount = n - to + from + 1;
                ans += firstLastCount / 3;

                out.println(ans);
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
