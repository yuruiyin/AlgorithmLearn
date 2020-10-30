package round676_div2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long x = in.nextInt();
                long y = in.nextInt();
                long[] c = new long[6];
                for (int i = 0; i < 6; i++) {
                    c[i] = in.nextInt();
                }

                long minCost = Long.MAX_VALUE;
                int minIdx = -1;
                for (int i = 0; i < 6; i++) {
                    if (c[i] < minCost) {
                        minCost = c[i];
                        minIdx = i;
                    }
                }

                int count = 0;
                for (int i = (minIdx + 1) % 6; count < 5; i = (i + 1) % 6) {
                    c[i] = Math.min(c[i], c[(i + 6 - 1) % 6] + c[(i + 1) % 6]);
                    count++;
                }

                if (x == 0) {
                    // 看y
                    if (y == 0) {
                        out.println(0);
                    } else if (y < 0) {
                        // 执行c[4]
                        long ans = (-y) * c[4];
                        out.println(ans);
                    } else {
                        // 执行c[1]
                        long ans = y * c[1];
                        out.println(ans);
                    }
                } else if (x < 0) {
                    if (y == 0) {
                        long ans = (-x) * c[2];
                        out.println(ans);
                    } else if (y < 0) {
                        if (y <= x) {
                            long ans = -x * c[3] + (-y + x) * c[4];
                            out.println(ans);
                        } else {
                            long a3 = (-x - y) / 2;
                            long a2 = -x - a3;
                            long ans = a3 * c[3] + a2 * c[2];
                            out.println(ans);
                        }
                    } else {
                        long a2 = -x;
                        long a1 = y;
                        long ans = a1 * c[1] + a2 * c[2];
                        out.println(ans);
                    }
                } else {
                    // x > 0
                    if (y == 0) {
                        long ans = x * c[5];
                        out.println(ans);
                    } else if (y < 0) {
                        long ans = x * c[5] + (-y) * c[4];
                        out.println(ans);
                    } else {
                        if (y >= x) {
                            long ans = x * c[0] + (y - x) * c[1];
                            out.println(ans);
                        } else {
                            long a0 = y;
                            long a5 = x - a0;
                            long ans = a0 * c[0] + a5 * c[5];
                            out.println(ans);
                        }
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
