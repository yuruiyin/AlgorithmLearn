package round746_div2;

import java.io.*;
import java.util.*;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private boolean isOk(Map<Integer, Set<Integer>> indexSetMap, int value, int l, int r, int x, int n) {
            Set<Integer> indexSet = indexSetMap.get(value);
            for (int j = l; j <= r; j++) {
                if (indexSet.contains(j)) {
                    continue;
                }

                if (j >= x || n - 1 - j >= x) {
                    continue;
                }

                return false;
            }

            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int x = in.nextInt();
                int[] arr = new int[n];
                Map<Integer, Set<Integer>> indexSetMap = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    int value = in.nextInt();
                    arr[i] = value;
                    if (!indexSetMap.containsKey(value)) {
                        indexSetMap.put(value, new HashSet<>());
                    }
                    indexSetMap.get(value).add(i);
                }

                sort(arr);

                boolean isOk = true;
                int l = 0;
                for (int i = 1; i < n; i++) {
                    if (arr[i] != arr[i - 1]) {
                        isOk = isOk(indexSetMap, arr[i - 1], l, i - 1, x, n);
                        if (!isOk) {
                            break;
                        }
                        l = i;
                    }
                }

                if (!isOk) {
                    out.println("NO");
                    continue;
                }

                int r = n - 1;
                isOk = isOk(indexSetMap, arr[n - 1], l, r, x, n);
                out.println(isOk ? "YES" : "NO");
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
