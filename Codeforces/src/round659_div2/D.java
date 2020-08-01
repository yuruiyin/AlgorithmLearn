package round659_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                int xor = 0;
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    xor ^= arr[i];
                }

                if (xor == 0) {
                    // 所有位上的1的个数都是偶数，最终最优的结果可能是每个人拿到的每一位上的1的个数都是相等的。
                    out.println("DRAW");
                    continue;
                }

                if (n == 1) {
                    out.println("WIN");
                    continue;
                }


                for (int i = 30; i >= 0; i--) {
                    int oneCount = 0;
                    for (int j = 0; j < n; j++) {
                        int curBit = arr[j] & (1 << i);
                        oneCount += curBit != 0 ? 1 : 0;
                    }

                    if ((oneCount & 1) == 0) {
                        continue;
                    }

                    if ((n & 1) == 0) {
                        out.println("WIN");
                    } else if (oneCount % 4 == 3) {
                        out.println("LOSE");
                    } else {
                        out.println("WIN");
                    }
                    break;
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
