package inszva_group_test01;

import java.io.*;
import java.util.*;

public class B {

    static class Task {

        private static final int MAX = 1000001;

        private boolean isOk(int[] arr, int k, int gcd) {
            int count = 0;
            for (int num : arr) {
                if (num % gcd == 0) {
                    count++;
                    if (count >= k) {
                        return true;
                    }
                }
            }

            return false;
        }

        private List<Integer> getAllFactors(int[] arr) {
            List<Integer> factorList = new ArrayList<>();
            boolean[] visited = new boolean[MAX];
            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i];
                if (visited[num])
                for (int j = 1; j * j <= num; j++) {
                    if (num % j == 0) {
                        if (!visited[j]) {
                            factorList.add(j);
                            visited[j] = true;
                        }

                        if (!visited[num / j]) {
                            factorList.add(num / j);
                            visited[num / j] = true;
                        }
                    }
                }
            }

            return factorList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            Arrays.sort(arr);

//            List<Integer> factorList = getAllFactors(arr);
//            Collections.sort(factorList);
//            int l = 0;
//            int r = n - 1;
//            int ans = 1;
//            while (l <= r) {
//                int mid = (l + r) >>> 1;
//                int gcd = factorList.get(mid);
//                if (isOk(arr, k, gcd)) {
//                    l = mid + 1;
//                    ans = gcd;
//                } else {
//                    r = mid - 1;
//                }
//            }
//
//            out.println(ans);
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
