package practice059;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {

    static class Task {

        private boolean isFound(char[] xiaoArr, char[] arr) {
            int curCmpIdx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (curCmpIdx >= xiaoArr.length) {
                    return true;
                }

                if (arr[i] == xiaoArr[curCmpIdx]) {
                    curCmpIdx++;
                }
            }

            if (curCmpIdx != xiaoArr.length) {
                return false;
            }

            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String str = in.next();
            char[] arr = str.toCharArray();
            int len = arr.length;
            char[] xiaoqiao = new char[]{'X', 'i', 'a', 'o', 'Q', 'i', 'a','o'};
            char[] xiaohuihui = new char[]{'X', 'i', 'a', 'o', 'H', 'u', 'i','H', 'u', 'i'};

            if (isFound(xiaoqiao, arr) && isFound(xiaohuihui, arr)) {
                out.println("Happy");
            } else {
                out.println("emm");
            }

        }
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(1, in, out);
        out.close();
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
