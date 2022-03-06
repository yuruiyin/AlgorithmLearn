package round749_div1_div2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int index;
            int value;
            Data(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        private boolean isPrime(int num) {
            int end = (int) Math.sqrt(num);
            for (int i = 2; i <= end; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                Data[] arr = new Data[n];
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int value = in.nextInt();
                    arr[i] = new Data(i, value);
                    sum += value;
                }

                if (!isPrime(sum)) {
                    out.println(n);
                    for (int i = 1; i <= n; i++) {
                        out.print(i + " ");
                    }
                    out.println();
                    continue;
                }

                out.println(n - 1);

                Arrays.sort(arr, new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.value - o2.value;
                    }
                });

                // 减去最小的奇数或者最小的偶数
                int sum1 = sum;
                int sum2 = sum;
                boolean isOddOk = false;
                boolean isEvenOk = false;
                int oddIdx = -1;
                int evenIdx = -1;
                for (int i = 0; i < n; i++) {
                    if (arr[i].value % 2 == 1 && !isOddOk) {
                        sum1 -= arr[i].value;
                        oddIdx = arr[i].index;
                        isOddOk = true;
                    } else if (arr[i].value % 2 == 0 && !isEvenOk) {
                        sum2 -= arr[i].value;
                        isEvenOk = true;
                        evenIdx = arr[i].index;
                    }
                    if (isOddOk && isEvenOk) {
                        break;
                    }
                }

                if (isPrime(sum2)) {
                    for (int i = 0; i < n; i++) {
                        if (i == oddIdx) {
                            continue;
                        }
                        out.print((i + 1) + " ");
                    }
                    out.println();
                } else {
                    if (sum1 >= sum2) {
                        for (int i = 0; i < n; i++) {
                            if (i == oddIdx) {
                                continue;
                            }
                            out.print((i + 1) + " ");
                        }
                        out.println();
                    } else {
                        for (int i = 0; i < n; i++) {
                            if (i == evenIdx) {
                                continue;
                            }
                            out.print((i + 1) + " ");
                        }
                        out.println();
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
