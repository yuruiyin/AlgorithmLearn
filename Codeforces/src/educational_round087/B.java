package educational_round087;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B {

    static class Task {

        private char[] charArr = new char[]{'1', '2', '3'};

        private List<Character> getOtherChars(char c) {
            List<Character> ansList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                if (c != charArr[i]) {
                    ansList.add(charArr[i]);
                }
            }
            return ansList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                char[] arr = in.next().toCharArray();
                int[] indexArr = new int[]{-1, -1, -1};
                int len = arr.length;
                int ansMin = Integer.MAX_VALUE;
                for (int i = 0; i < len; i++) {
                    char cur = arr[i];
                    List<Character> otherChars = getOtherChars(cur);
                    boolean isOk = true;
                    int minIdx = Integer.MAX_VALUE;
                    for (Character otherChar : otherChars) {
                        int tmpIdx = indexArr[otherChar - '1'];
                        if (tmpIdx == -1) {
                            isOk = false;
                            break;
                        }
                        minIdx = Math.min(minIdx, tmpIdx);
                    }

                    indexArr[cur - '1'] = i;
                    if (!isOk) {
                        continue;
                    }

                    ansMin = Math.min(ansMin, i - minIdx + 1);
                }

                out.println(ansMin == Integer.MAX_VALUE ? 0 : ansMin);
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
