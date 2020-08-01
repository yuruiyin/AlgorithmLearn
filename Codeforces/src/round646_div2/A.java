package round646_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int x = in.nextInt();
                int oddCount = 0;
                for (int i = 0; i < n; i++) {
                    int a = in.nextInt();
                    if (a % 2 == 1) {
                        oddCount++;
                    }
                }

                if (oddCount == 0) {
                    out.println("No");
                    continue;
                }

                int evenCount = n - oddCount;
                if (x % 2 == 0) {
                    if (x == n) {
                        if (oddCount % 2 == 0) {
                            out.println("No");
                        } else {
                            out.println("Yes");
                        }
                    } else {
                        if (evenCount > 0) {
                            out.println("Yes");
                        } else {
                            out.println("No");
                        }
                    }

                } else {
                    if (x == n) {
                        if (oddCount % 2 == 0) {
                            out.println("No");
                        } else {
                            out.println("Yes");
                        }
                    } else {
                        out.println("Yes");
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
