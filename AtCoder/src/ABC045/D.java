package ABC045;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            long rowCnt = in.nextInt();
            long colCnt = in.nextLong();
            int n = in.nextInt();
            Map<Long, Integer> countMap = new HashMap<>();
            while ((n--) > 0) {
                int row = in.nextInt() - 1;
                int col = in.nextInt() - 1;
                // (row, col)图成黑色
                // 以当前方块为中心，让周围包含当前黑方块的9个3x3正方形的黑色方块数+1
                for (int i = Math.max(0, row - 2); i <= row; i++) {
                    if (i >= rowCnt - 2) {
                        break;
                    }

                    for (int j = Math.max(0, col - 2); j <= col; j++) {
                        // （i， j）是3x3方阵的左上角坐标
                        if (j >= colCnt - 2) {
                            break;
                        }

                        long key = i * colCnt + j;
                        countMap.put(key, countMap.getOrDefault(key, 0) + 1);
                    }
                }
            }

            long[] countArr = new long[10];
            for (Long key : countMap.keySet()) {
                countArr[countMap.get(key)]++;
            }

            long zeroCount = (rowCnt - 2) * (colCnt - 2) - countMap.keySet().size();
            out.println(zeroCount);
            for (int i = 1; i <= 9; i++) {
                out.println(countArr[i]);
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

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
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
