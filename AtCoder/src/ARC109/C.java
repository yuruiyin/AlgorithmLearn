package ARC109;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private char getWin(char c1, char c2) {
            if (c1 == c2) {
                return c1;
            }

            if (c1 == 'R') {
                return c2 == 'S' ? 'R' : 'P';
            } else if (c1 == 'S') {
                return c2 == 'P' ? 'S' : 'R';
            } else {
                return c2 == 'R' ? 'P' : 'S';
            }
        }

        private int[] indexArr;
        private BigInteger bigN;

        private int getIdx(BigInteger bigInteger) {
            return Integer.parseInt(bigInteger.mod(bigN).toString());
        }


        private char dfs(char[] arr, BigInteger l, BigInteger r) {
            if (l.equals(r)) {
                return arr[getIdx(l)];
            }

            BigInteger mid = l.add(r).divide(BigInteger.TWO);
            char left = dfs(arr, l, mid);
            char right = dfs(arr, mid.add(BigInteger.ONE), r);
            return getWin(left, right);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            char[] arr = in.next().toCharArray();

            bigN = new BigInteger(n + "");
            BigInteger bigInteger = new BigInteger("1");
            for (int i = 1; i <= k; i++) {
                bigInteger = bigInteger.multiply(new BigInteger("2"));
            }
            bigInteger = bigInteger.subtract(new BigInteger("1"));
            out.println(dfs(arr, BigInteger.ZERO, bigInteger));
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
