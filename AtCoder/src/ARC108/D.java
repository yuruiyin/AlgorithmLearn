package ARC108;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private static final int MOD = (int) (1e9 + 7);
        private int n;
        private Set<String> visited;
        private char caa;
        private char cab;
        private char cba;
        private char cbb;

        private long dp(String s) {
            if (visited.contains(s)) {
                return 0;
            }
            visited.add(s);

            int len = s.length();
            if (len == n) {
                return 1;
            }

            long ans = 0;
            for (int i = 0; i < len - 1; i++) {
                char c1 = s.charAt(i);
                char c2 = s.charAt(i + 1);
                if (c1 == 'A' && c2 == 'A') {
                    ans = (ans + dp(s.substring(0, i + 1) + caa + s.substring(i + 1, len))) % MOD;
                } else if (c1 == 'A' && c2 == 'B') {
                    ans = (ans + dp(s.substring(0, i + 1) + cab + s.substring(i + 1, len))) % MOD;
                } else if (c1 == 'B' && c2 == 'A') {
                    ans = (ans + dp(s.substring(0, i + 1) + cba + s.substring(i + 1, len))) % MOD;
                } else {
                    ans = (ans + dp(s.substring(0, i + 1) + cbb + s.substring(i + 1, len))) % MOD;
                }
            }

            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            caa = in.next().charAt(0);
            cab = in.next().charAt(0);
            cba = in.next().charAt(0);
            cbb = in.next().charAt(0);

            visited = new HashSet<>();
            long ans = dp("AB");
            out.println(ans % MOD);
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
