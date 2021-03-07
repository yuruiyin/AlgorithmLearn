package ABC186;

import java.io.*;
import java.util.*;

public class F {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private static final long MAX = 200001;

        class Data {
            int x;
            int y;
            Data(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long m = in.nextInt();
            long n = in.nextInt();
            int k = in.nextInt();
            Data[] datas = new Data[k];
            int[] colDisableCount = new int[(int) n + 1];
            int[] rowDisableCount = new int[(int) m + 1];
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < k; i++) {
                datas[i] = new Data(in.nextInt(), in.nextInt());
                set.add(datas[i].x * MAX + datas[i].y);
                rowDisableCount[datas[i].x]++;
                colDisableCount[datas[i].y]++;
            }

            Arrays.sort(datas, (o1, o2) -> o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x);

            long ans = n * m;
            boolean isYDone = false;
            boolean isXDone = false;
            for (int i = 0; i < k; i++) {
                Data data = datas[i];
                int x = data.x;
                int y = data.y;
                if (x == 1) {
                    if (isXDone) {
                        continue;
                    } else {
                        isXDone = true;
                        ans -= (n - y + 1);
                    }
                } else if (y == 1) {
                    if (isYDone) {
                        continue;
                    } else {
                        ans -= (m - x + 1);
                        isYDone = true;
                    }
                } else if (x == m) {

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
