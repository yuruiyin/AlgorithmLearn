package educational_round093;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        private int[] getArr(InputReader in, int len) {
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            return arr;
        }

        private int[] getAnotherTwoIndex(int index) {
            int[] ansArr = new int[2];
            int size = 0;
            for (int i = 0; i < 3; i++) {
                if (i == index) {
                    continue;
                }
                ansArr[size++] = i;
            }
            return ansArr;
        }

        private Long[][][] memo;
        private int[] arrR;
        private int[] arrG;
        private int[] arrB;
        private int r;
        private int g;
        private int b;

        private long dp(int idxR, int idxG, int idxB) {
            if (memo[idxR][idxG][idxB] != null) {
                return memo[idxR][idxG][idxB];
            }

            long res1 = 0;
            if (idxR != r && idxG != g) {
                res1 = arrR[idxR] * arrG[idxG] + dp(idxR + 1, idxG + 1, idxB);
            }

            long res2 = 0;
            if (idxR != r && idxB != b) {
                res2 = arrR[idxR] * arrB[idxB] + dp(idxR + 1, idxG, idxB + 1);
            }

            long res3 = 0;
            if (idxG != g && idxB != b) {
                res3 = arrG[idxG] * arrB[idxB] + dp(idxR, idxG + 1, idxB + 1);
            }

            memo[idxR][idxG][idxB] = Math.max(res1, Math.max(res2, res3));
            return memo[idxR][idxG][idxB];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            r = in.nextInt();
            g = in.nextInt();
            b = in.nextInt();

            arrR = getArr(in, r);
            arrG = getArr(in, g);
            arrB = getArr(in, b);
            memo = new Long[r + 1][g + 1][b + 1];
            sortDesc(arrR);
            sortDesc(arrG);
            sortDesc(arrB);
            long ans = dp(0, 0, 0);
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
