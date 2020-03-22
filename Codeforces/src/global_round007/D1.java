package global_round007;

import java.io.*;
import java.util.StringTokenizer;

public class D1 {

    static class Task {

        private int[] getMaxPalindrome1(char[] arr, int from, int to) {
            for (int cur = from; cur < to; cur++) {
                int left = cur;
                boolean isFound = true;
                int right = to;
                while (left < right) {
                    if (arr[left] != arr[right]) {
                        isFound = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isFound) {
                    return new int[]{cur, to};
                }
            }

            return new int[]{to, to};
        }

        private int[] getMaxPalindrome(char[] arr, int from, int to) {
            for (int cur = to; cur > from; cur--) {
                int left = from;
                boolean isFound = true;
                int right = cur;
                while (left < right) {
                    if (arr[left] != arr[right]) {
                        isFound = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isFound) {
                    return new int[]{from, cur};
                }
            }

            return new int[]{from, from};
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                String str = in.next();
                char[] arr = str.toCharArray();

                // 两个方向都要判断
                int len = arr.length;
                int left = 0;
                int right = len - 1;

                while (left < right) {
                    if (arr[left] == arr[right]) {
                        left++;
                        right--;
                    } else {
                        break;
                    }
                }

                if (left >= right) {
                    out.println(str);
                    continue;
                }

                // 从左边找最大的 和从右边找最大的回文串
                int[] leftToRight = getMaxPalindrome(arr, left, right);
                int[] rightToLeft = getMaxPalindrome1(arr, left, right);
                String ans = "";
                if (leftToRight[1] - leftToRight[0] > rightToLeft[1] - rightToLeft[0]) {
                    ans = str.substring(0, leftToRight[1] + 1);
                    if (right < len - 1) {
                        ans += str.substring(right + 1, len);
                    }
                } else {
                    if (left > 0) {
                        ans = str.substring(0, left);
                    }
                    ans = ans + str.substring(rightToLeft[0]);
                }

                out.println(ans);
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
