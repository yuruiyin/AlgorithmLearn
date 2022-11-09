package global_round023;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    // 注意不要使用System.out.println
    static class Task {

        class Data {
            int idx;
            long diff;
            Data(int idx, long diff) {
                this.idx = idx;
                this.diff = diff;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                PriorityQueue<Data> heap = new PriorityQueue<>(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {
                        return Long.compare(o1.diff, o2.diff);
                    }
                });
                for (int i = 1; i < n; i++) {
                    long diff = arr[i] - arr[i - 1];
                    if (diff < 0) {
                        heap.add(new Data(i + 1, Math.abs(diff)));
                    }
                }

                int[] ansArr = new int[n];
                int idx = 0;
                int start = 1;

                for (Data data : heap) {
                    long diff = data.diff;
                    long sum = 0;
                    int nextStart = 0;
                    for (int i = start; i <= n; i++) {
                        sum += i;
                        ansArr[idx++] = data.idx;
                        if (sum >= diff) {
                            nextStart = i + 1;
                            break;
                        }
                    }
                    start = nextStart;
                }

                if (idx < n) {
                    for (int i = idx; i < n; i++) {
                        ansArr[i] = 1;
                    }
                }

                for (int i = 0; i < n; i++) {
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
