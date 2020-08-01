package round650_div3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private int getCount(int n, int k) {
            return n / (k + 1) + (n % (k + 1) == 0 ? 0 : 1);
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                char[] arr = in.next().toCharArray();
                List<Integer> oneIndexList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (arr[i] == '1') {
                        oneIndexList.add(i);
                    }
                }

                int oneSize = oneIndexList.size();
                int ans = 0;
                if (oneSize == 0) {
                    ans = getCount(n, k);
                } else if (oneSize == 1) {
                    int index = oneIndexList.get(0);
                    ans = getCount(index + 1, k) + getCount(n - index, k) - 2;
                } else {
                    int l = oneIndexList.get(0);
                    int r = oneIndexList.get(oneSize - 1);
                    ans = getCount(l + 1, k) + getCount(n - r, k) - 2;
                    for (int i = 1; i < oneSize; i++) {
                        int diff = oneIndexList.get(i) - oneIndexList.get(i-1);
                        ans += (diff / (k + 1) - 1);
                    }
                }

                out.println(ans);
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
