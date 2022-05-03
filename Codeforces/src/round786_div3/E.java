package round786_div3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            int ansMin = Integer.MAX_VALUE;

            // 只打一个
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    int count = arr[i] / 2 + (arr[i] % 2);
                    count += Math.max(0, arr[i + 1] - count);
                    ansMin = Math.min(ansMin, count);
                } else if (i == n - 1) {
                    int count = arr[i] / 2 + (arr[i] % 2);
                    count += Math.max(0, arr[i - 1] - count);
                    ansMin = Math.min(ansMin, count);
                } else {
                    // 左右都要考虑
                    int count = arr[i] / 2 + (arr[i] % 2);
                    count += Math.max(0, Math.min(arr[i - 1] - count, arr[i + 1] - count));
                    ansMin = Math.min(ansMin, Math.min(count, Math.max(arr[i - 1], arr[i + 1])));

                    if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                        int min = Math.min(arr[i - 1], arr[i + 1]);
                        int max = Math.max(arr[i - 1], arr[i + 1]);
                        if (arr[i] > 2 * min) {
                            count = min + (max - min) / 2 + (max - min) % 2;
                            ansMin = Math.min(ansMin, count);
                        }
                    }

                }
            }

            // 打相邻两个
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] >= arr[i + 1] * 2 || arr[i] + 1 >= arr[i + 1] * 2) {
                    // 只要击打当前的即可
                    ansMin = Math.min(ansMin, arr[i] / 2 + (arr[i] % 2));
                    continue;
                }

                if (arr[i + 1] >= arr[i] * 2 || arr[i + 1] + 1 >= arr[i] * 2) {
                    // 只要击打当前的即可
                    ansMin = Math.min(ansMin, arr[i + 1] / 2 + (arr[i + 1] % 2));
                    continue;
                }

                int max = Math.max(arr[i], arr[i + 1]);
                int min = Math.min(arr[i], arr[i + 1]);
                int x = Math.max(1, (2 * min - max) / 3);
                if ((min - 2 * x) * 2 > max - x) {
                    x++;
                }
                int count = x + (max - x) / 2 + (max - x) % 2;
                ansMin = Math.min(ansMin, count);

                x = Math.max(1, (2 * max - min) / 3);
                if ((max - 2 * x) * 2 > min - x) {
                    x++;
                }
                count = x + (min - x) / 2 + (min - x) % 2;
                ansMin = Math.min(ansMin, count);


            }

            // 打不相邻两个，那就是打最小的
            if (n == 2) {
                out.println(ansMin);
                return;
            }
            // todo
            sort(arr);
            int max1 = arr[0] / 2 + (arr[0] % 2);
            int max2 = arr[1] / 2 + (arr[1] % 2);
            ansMin = Math.min(ansMin, max1 + max2);
            out.println(ansMin);
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
