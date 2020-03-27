package global_round007;

import java.io.*;
import java.util.StringTokenizer;

public class D2 {

    static class Task {

        private StrHash strHash;
        private StrHash reverseStrHash;

        private boolean isPalindrome(char[] arr, int left, int right) {
            int len = arr.length;
            int count = right - left + 1;
            int mid = (left + right) >>> 1;
            long leftHash;
            long rightHash;
            if (count % 2 == 0) {
                leftHash = strHash.getSubStrHash(left, mid);
                rightHash = reverseStrHash.getSubStrHash(len - right - 1, len - mid - 2);
            } else {
                leftHash = strHash.getSubStrHash(left, mid - 1);
                rightHash = reverseStrHash.getSubStrHash(len - right - 1, len - mid - 2);
            }
            return leftHash == rightHash;
        }

        // 左边固定
        private int[] getMaxPalindromeLeftToRight(char[] arr, int from, int to) {
            int left = from;
            for (int right = to; right > left; right--) {
                if (isPalindrome(arr, left, right)) {
                    return new int[]{left, right};
                }
            }
            return new int[] {left, left};
        }

        // 右边固定
        private int[] getMaxPalindromeRightToLeft(char[] arr, int from, int to) {
            int right = to;
            for (int left = from; left < right; left++) {
                if (isPalindrome(arr, left, right)) {
                    return new int[]{left, right};
                }
            }
            return new int[]{to, to};
        }

        private void calcStrHash(String str) {
            String reverseStr = new StringBuilder(str).reverse().toString();
            strHash = new StrHash(str.toCharArray());
            reverseStrHash = new StrHash(reverseStr.toCharArray());
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

                while (left < right && arr[left] == arr[right]) {
                    left++;
                    right--;
                }

                if (left >= right) {
                    out.println(str);
                    continue;
                }

                // 从左边找最大的 和从右边找最大的回文串
                calcStrHash(str);
                int[] leftToRight = getMaxPalindromeLeftToRight(arr, left, right);
                int[] rightToLeft = getMaxPalindromeRightToLeft(arr, left, right);
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
        new Thread(null, D2::solve, "1", 1 << 26).start();
    }

    static class StrHash {

        private static final long P = 805306457;
        private static final long MOD = (int) (1e9+7);
        private long[] hash;
        private long[] power;
        private char[] arr;

        public StrHash(char[] arr) {
            this.arr = arr;
            int len = arr.length;
            hash = new long[len];
            power = new long[len];
            calcHashAndPower();
        }

        private void calcHashAndPower() {
            hash[0] = arr[0];
            power[0] = 1;
            for (int i = 1; i < arr.length; i++) {
                hash[i] = (hash[i-1] * P + arr[i]) % MOD;
                power[i] = (power[i-1] * P) % MOD;
            }
        }

        private long getSubStrHash(int l, int r) {
            if (l == 0) {
                return hash[r];
            }
            return ((hash[r] - power[r-l+1] * hash[l-1]) % MOD + MOD) % MOD;
        }

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
