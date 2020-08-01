package round02;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

    static class Task {

        private Set<Character> set;

        private boolean isOk(char c1, char c2) {
            return !set.contains(c1) && set.contains(c2);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            char[] arr = in.next().toCharArray();
            int n = arr.length;
            set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');

            long ans = 0;

            for (int i = 0; i < n - 5; ) {
                char c = arr[i];
                if (set.contains(c)) {
                    i++;
                    continue;
                }

                if (!set.contains(arr[i + 1])) {
                    i++;
                    continue;
                }

                if (!isOk(arr[i + 2], arr[i + 3])) {
                    i += 3;
                    continue;
                }

                int j;
                for (j = i + 4; j < n - 1; j+=2) {
                    if (!(arr[j] == arr[i+2] && arr[j + 1] == arr[i+3])) {
                        break;
                    }
                }

                int count = j - i;
                if (count >= 6) {
                    long nn = (count - 4) / 2;
                    ans += (nn + 1) * nn / 2;
                    i = j - 2;
                } else {
                    i += 2;
                }

                if (j >= n - 1) {
                    break;
                }
            }

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
