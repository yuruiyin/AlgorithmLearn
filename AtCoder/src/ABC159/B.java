package ABC159;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static class Task {

        private boolean isPalindrome(char[] arr, int left, int right) {
            left--;
            right--;
            while (left < right) {
                if (arr[left] != arr[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            String str = in.next();
            char[] arr = str.toCharArray();
            int len = arr.length;

            boolean isOk = isPalindrome(arr, 1, len) && isPalindrome(arr, 1, (len - 1) / 2) &&
                    isPalindrome(arr, (len + 3) / 2, len);

            out.println(isOk ? "Yes" : "No");
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
