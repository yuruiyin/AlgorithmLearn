package round631;

import java.io.*;
import java.util.*;

public class B {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }

                int[] preDiffCountArr = new int[n];
                Set<Integer> preSet = new HashSet<>();
                int[] preMaxArr = new int[n];
                preDiffCountArr[0] = 1;
                preMaxArr[0] = arr[0];
                preSet.add(arr[0]);
                for (int i = 1; i < n; i++) {
                    preSet.add(arr[i]);
                    preDiffCountArr[i] = preSet.size();
                    preMaxArr[i] = Math.max(preMaxArr[i - 1], arr[i]);
                }

                int[] sufDiffCountArr = new int[n];
                Set<Integer> sufSet = new HashSet<>();
                int[] sufMaxArr = new int[n];
                sufDiffCountArr[n - 1] = 1;
                sufMaxArr[n - 1] = arr[n - 1];
                sufSet.add(arr[n - 1]);
                for (int i = n - 2; i >= 0; i--) {
                    sufSet.add(arr[i]);
                    sufDiffCountArr[i] = sufSet.size();
                    sufMaxArr[i] = Math.max(sufMaxArr[i + 1], arr[i]);
                }

                List<int[]> ansList = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    int preDiffCount = preDiffCountArr[i];
                    int preMax = preMaxArr[i];
                    int sufDiffCount = sufDiffCountArr[i + 1];
                    int sufMax = sufMaxArr[i + 1];

                    if (preDiffCount == i + 1 && preMax == i + 1 && sufDiffCount == n - i - 1 && sufMax == n - i - 1) {
                        ansList.add(new int[]{i + 1, n - i - 1});
                    }
                }

                if (ansList.isEmpty()) {
                    out.println(0);
                    continue;
                }

                out.println(ansList.size());
                for (int[] num : ansList) {
                    out.println(num[0] + " " + num[1]);
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
