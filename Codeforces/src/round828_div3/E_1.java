package round828_div3;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class E_1 {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private Set<Long> getAllFactors(long num) {
            Set<Long> list = new HashSet<>();
            int end = (int) Math.sqrt(num);
            for (int i = 1; i <= end; i++) {
                if (num % i == 0) {
                    list.add((long) i);
                    list.add(num / i);
                }
            }
            return list;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                long a = in.nextInt();
                long b = in.nextInt();
                long c = in.nextInt();
                long d = in.nextInt();
                long sum = a * b;

                if (sum == 1) {
                    out.println("2 2");
                    continue;
                }

                long[] ansArr = new long[2];
                Arrays.fill(ansArr, -1);
                Set<Long> factors1 = getAllFactors(a);
                Set<Long> factors2 = getAllFactors(b);
                Set<Long> allFactors = new HashSet<>(factors1);
                allFactors.addAll(factors2);
                for (long f1: factors1) {
                    for (long f2: factors2) {
                        allFactors.add(f1*f2);
                    }
                }
                for (long factor1 : allFactors) {
                    long factor2 = sum / factor1;
                    long count1 = (a + 1) / factor1;
                    if ((a + 1) % factor1 != 0) {
                        count1++;
                    }
                    long x = factor1 * count1;
                    if (x > c) {
                        continue;
                    }
                    long count2 = (b + 1) / factor2;
                    if ((b + 1) % factor2 != 0) {
                        count2++;
                    }
                    long y = factor2 * count2;
                    if (y <= d) {
                        ansArr[0] = x;
                        ansArr[1] = y;
                        break;
                    }
                }

                out.println(ansArr[0] + " " + ansArr[1]);
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
