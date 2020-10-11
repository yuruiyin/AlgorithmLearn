package rematch_2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P1002 {

    static class Task {

        private int[] getDiffCountAfterAdd1(char[] arr1, char[] arr2, List<Character> add1List, int originDiffCount) {
            int carry = 1;
            int n = arr1.length;
            int i;
            for (i = 0; i < n; i++) {
                char c = (char) ((arr1[i] - '0' + carry) % 2 + '0');
                add1List.add(c);
                carry = (arr1[i] - '0' + carry) / 2;
                if (carry == 0) {
                    break;
                }
            }

            int end = Math.min(i, n - 1);
            int preOriginDiffCount = 0;
            int diffCount = carry;
            for (int j = 0; j <= end; j++) {
                diffCount += (add1List.get(j) != arr2[j] ? 1 : 0);
                preOriginDiffCount += (arr1[j] != arr2[j] ? 1 : 0);
            }

            return new int[]{diffCount + (originDiffCount - preOriginDiffCount), carry};
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[] arr1 = in.next().toCharArray();
                char[] arr2 = in.next().toCharArray();

                if (n == 1) {
                    out.println(arr1[0] == arr2[0] ? 0 : 1);
                    continue;
                }

                int diffCount = 0;
                for (int i = 0; i < n; i++) {
                    diffCount += (arr1[i] == arr2[i] ? 0 : 1);
                }

                int i = 0;
                long ans = 0;

                while (diffCount > 0) {
                    if (arr1[i] == arr2[i]) {
                        i++;
                        continue;
                    }

                    ans++;
                    if (arr1[i] == '0' && arr2[i] == '1') {
                        arr1[i] = '1';
                        diffCount--;
                        i++;
                    } else {
                        // arr1 加1试试
                        List<Character> add1List = new ArrayList<>();
                        int[] res = getDiffCountAfterAdd1(arr1, arr2, add1List, diffCount);
                        int diffCount1 = res[0];
                        int carry = res[1];
                        if (diffCount - diffCount1 >= 2) {
                            diffCount = diffCount1;
                            if (carry == 1) {
                                diffCount--;
                                ans++;
                            }
                            for (int j = 0; j < add1List.size(); j++) {
                                arr1[j] = add1List.get(j);
                            }
                            i = 0;
                        } else {
                            arr1[i] = '0';
                            diffCount--;
                            i++;
                        }
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
