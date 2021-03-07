package educational_round104;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int totalCount = n * (n - 1) / 2;
                if (n % 2 == 1) {
                    // 奇数平局个数为0即可
                    int each = (n - 1) / 2;
                    int[] ansArr = new int[totalCount];
                    int count = 0;
                    for (int i = 1; i <= n - 1; i++) {
                        for (int j = i + 1; j <= n; j++) {
                            if (j - (i + 1) + 1 <= each) {
                                ansArr[count++] = 1;
                            } else {
                                ansArr[count++] = -1;
                            }
                        }
                    }

                    for (int i = 0; i < totalCount; i++) {
                        out.print(ansArr[i] + " ");
                    }
                    out.println();
                } else {

                    if (n == 2) {
                        out.println(0);
                        continue;
                    }

                    int[] ansArr = new int[totalCount];
                    int count = 0;
                    int mid = n / 2;
                    for (int i = 1; i <= n - 1; i++) {
                        for (int j = i + 1; j <= n; j++) {
                            if (j <= mid) {
                                ansArr[count++] = 1;
                            } else if (j == mid + 1) {
                                ansArr[count++] = 0;
                            } else {
                                ansArr[count++] = -1;
                            }
                        }
                        mid++;
                    }

                    for (int i = 0; i < totalCount; i++) {
                        out.print(ansArr[i] + " ");
                    }
                    out.println();
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
