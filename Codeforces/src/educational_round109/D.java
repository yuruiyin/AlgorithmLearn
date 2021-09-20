package educational_round109;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private void swap(int[] arr, int i, int j) {
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            long ans = 0;

            // 求下一个0的位置
//            LinkedList<Integer> zeroIdxList = new LinkedList<>();
//            for (int i = 0; i < n; i++) {
//                if (arr[i] == 0) {
//                    zeroIdxList.add(i);
//                }
//            }

            for (int i = 0; i < n; i++) {
                // 求后缀0的个数
                int[] suffixZeroCountArr = new int[n];
                suffixZeroCountArr[n - 1] = arr[n - 1] == 0 ? 1 : 0;
                int[] suffixOneCountArr = new int[n];
                suffixOneCountArr[n - 1] = arr[n - 1] == 1 ? 1 : 0;
                for (int k = n - 2; k >= 0; k--) {
                    suffixZeroCountArr[k] = suffixZeroCountArr[k + 1] + (arr[k] == 0 ? 1 : 0);
                    suffixOneCountArr[k] = suffixOneCountArr[k + 1] + (arr[k] == 1 ? 1 : 0);
                }

                if (arr[i] == 1) {
                    int suffixZeroCount = suffixZeroCountArr[i];
                    int suffixOneCount = suffixOneCountArr[i];
                    if (suffixOneCount > suffixZeroCount) {
                        // 后面1的个数比0多
                        for (int j = i - 1; j >= 0; j--) {
                            if (arr[j] == 0) {
                                arr[j] = -1;
                                ans += Math.abs(j - i);
                                break;
                            }
                        }
                    } else {
                        // 判断哪个更近
                        int left = n + 1;
                        for (int j = i - 1; j >= 0; j--) {
                            if (arr[j] == 0) {
                                left =  Math.abs(j - i);
                                break;
                            }
                        }

                        int right = n + 1;
                        for (int j = i + 1; j < n; j++) {
                            if (arr[j] == 0) {
                                right = Math.abs(j - i);
                                break;
                            }
                        }

                        if (left <= right) {
                            arr[i - left] = -1;
                            ans += left;
                        } else {
                            arr[i + right] = -1;
                            ans += right;
                        }

                    }
                }
            }

            out.println(ans);

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
