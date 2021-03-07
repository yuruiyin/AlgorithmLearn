package round685_div2;

import java.io.*;
import java.util.*;

public class A {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private int getMaxFactor(int num) {
            int end = (int) Math.sqrt(num);
            for (int i = 2; i <= end; i++) {
                if (num % i == 0) {
                    return num / i;
                }
            }
            return -1;
        }

        private static List<Integer> getAllFactors(int num) {
            List<Integer> list = new ArrayList<>();
            int end = (int) Math.sqrt(num);
            for (int i = 2; i <= end; i++) {
                if (num % i == 0) {
                    list.add(i);
                    if (num / i != i) {
                        list.add(num / i);
                    }
                }
            }
            return list;
        }

        private Map<Integer, Integer> memo;

        private int dp(int num) {
            if (num == 1) {
                return 0;
            }

            if (memo.containsKey(num)) {
                return memo.get(num);
            }

            List<Integer> factors = getAllFactors(num);
            if (factors.isEmpty()) {
                return 1 + dp(num - 1);
            }

            int ans = Integer.MAX_VALUE;
            for (int factor : factors) {
                ans = Math.min(ans, 1 + dp(num / factor));
            }
            memo.put(num, ans);
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            memo = new HashMap<>();
            while ((t--) > 0) {
                int n = in.nextInt();
                if (n == 1) {
                    out.println(0);
                } else if (n == 2) {
                    out.println(1);
                } else if (n == 3) {
                    out.println(2);
                } else if (n % 2 == 0) {
                    out.println(2);
                } else {
                    out.println(3);
                }


//                int ans = dp(n);
//                out.println(ans);
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
