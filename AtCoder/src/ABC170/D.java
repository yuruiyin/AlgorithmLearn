package ABC170;

import java.io.*;
import java.util.*;

public class D {

    static class Task {

        private List<Integer> getAllFactors(int num) {
            List<Integer> list = new ArrayList<>();
            int end = (int) Math.sqrt(num);
            for (int i = 1; i <= end; i++) {
                if (num % i == 0) {
                    list.add(i);
                    list.add(num / i);
                }
            }

            return list;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
            }

            int ansCount = 0;
            for (int i = 0; i < n; i++) {
                List<Integer> factors = getAllFactors(arr[i]);
                boolean isOk = true;
                for (int factor : factors) {
                    if (factor == arr[i] && countMap.getOrDefault(factor, 0) > 1 ||
                            factor != arr[i] && countMap.containsKey(factor)) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    ansCount++;
                }
            }

            out.println(ansCount);
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
