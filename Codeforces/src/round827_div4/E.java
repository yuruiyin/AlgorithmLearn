package round827_div4;

import java.io.*;
import java.util.*;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        class Data {
            int value;
            int idx;
            Data(int value, int idx) {
                this.value = value;
                this.idx = idx;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int q = in.nextInt();
                long[] arr = new long[n];
                List<Data> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                for (int i = 0; i < q; i++) {
                    list.add(new Data(in.nextInt(), i));
                }

                Collections.sort(list, new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return o1.value - o2.value;
                    }
                });

                long[] ansArr = new long[q];
                int start = 0;
                long preSum = 0;
                for (Data data : list) {
                    int idx = data.idx;
                    int value = data.value;
                    int nextStart = 0;
                    for (int i = start; i < n; i++) {
                        if (arr[i] > value) {
                            break;
                        }
                        nextStart = i + 1;
                        preSum += arr[i];
                    }
                    if (nextStart == 0) {
                        // 说明都不行
                        ansArr[idx] = preSum;
                    } else {
                        ansArr[idx] = preSum;
                        start = nextStart;
                    }
                }

                for (int i = 0; i < q; i++) {
                    out.print(ansArr[i] + " ");
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
