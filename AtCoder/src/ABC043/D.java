package ABC043;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            List<Integer>[] indexListArr = new ArrayList[26];
            char[] arr = in.next().toCharArray();
            int len = arr.length;
            for (int i = 0; i < len; i++) {
                char c = arr[i];
                if (indexListArr[c - 'a'] == null) {
                    indexListArr[c - 'a'] = new ArrayList<>();
                }
                indexListArr[c - 'a'].add(i);
            }

            for (int i = 0; i < 26; i++) {
                List<Integer> indexList = indexListArr[i];
                if (indexList == null || indexList.size() == 1) {
                    continue;
                }

                // 双指针
                int left = 0;
                int right = indexList.size() - 1;
                boolean isOk = false;
                while (left < right) {
                    int leftIdx = indexList.get(left);
                    int rightIdx = indexList.get(right);
                    int curCharCount = right - left + 1;
                    int curStrLen = rightIdx - leftIdx + 1;
                    if (curCharCount * 2 > curStrLen) {
                        isOk = true;
                        break;
                    }

                    if (indexList.get(left + 1) - leftIdx >= rightIdx - indexList.get(right - 1)) {
                        left++;
                    } else {
                        right--;
                    }
                }

                if (isOk) {
                    out.println((indexList.get(left) + 1) + " " + (indexList.get(right) + 1));
                    return;
                }
            }

            out.println("-1 -1");
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
