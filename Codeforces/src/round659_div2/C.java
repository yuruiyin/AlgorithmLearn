import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[] arr1 = in.next().toCharArray();
                char[] arr2 = in.next().toCharArray();

                boolean isOk = true;

                for (int i = 0; i < n; i++) {
                    if (arr1[i] > arr2[i]) {
                        isOk = false;
                        break;
                    }
                }

                if (!isOk) {
                    out.println(-1);
                    continue;
                }

                long minCount = 0;
                for (char c = 'a'; c <= 't'; c++) {
                    char minChar2 = 't';
                    boolean isAllSame = true;
                    for (int i = 0; i < n; i++) {
                        if (arr1[i] == c) {
                            if (arr2[i] != arr1[i] && arr2[i] <= minChar2) {
                                isAllSame = false;
                                minChar2 = arr2[i];
                            }
                        }
                    }

                    if (isAllSame) {
                        continue;
                    }

                    for (int i = 0; i < n; i++) {
                        if (arr1[i] == c) {
                            if (arr1[i] == arr2[i]) {
                                continue;
                            }

                            arr1[i] = minChar2;
                        }
                    }

                    minCount++;
                }

                out.println(minCount);
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