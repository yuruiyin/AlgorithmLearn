package round632_div2;

import java.io.*;
import java.util.*;

public class C {

    static class Task {

        private int findFirstBiggerOrEqual(List<Integer> list, int target) {
            int low = 0;
            int high = list.size() - 1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (target <= list.get(mid)) {
                    if (mid == 0 || target > list.get(mid - 1)) {
                        return mid;
                    }

                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            return -1;
        }

        // 差分
        public int[] getModifiedArray(int length, int[][] updates) {
            int[] diff = new int[length];
            for (int[] update : updates) {
                int startIdx = update[0];
                int endIdx = update[1];
                int inc = update[2];
                diff[startIdx] += inc;
                if (endIdx < length - 1) {
                    diff[endIdx + 1] -= inc;
                }
            }

            for (int i = 1; i < length; i++) {
                diff[i] += diff[i-1];
            }

            return diff;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }

            long ans = 0;
            Map<Long, List<Integer>> indexMap = new HashMap<>();
            long sum = 0;
            long okIndex = -1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum == 0) {
                    okIndex = i;
                }
                if (!indexMap.containsKey(sum)) {
                    indexMap.put(sum, new ArrayList<>());
                }
                indexMap.get(sum).add(i);
            }

            if (okIndex >= 0) {
                ans += okIndex;
            } else {
                ans += n;
            }

            long pre = arr[0];
            for (int i = 1; i < n; i++) {
                if (!indexMap.containsKey(pre)) {
                    ans += n - i;
                } else {
                    List<Integer> indexList = indexMap.get(pre);
                    int firstBigger = findFirstBiggerOrEqual(indexList, i);
                    if (firstBigger == -1) {
                        ans += n - i;
                    } else {
                        ans += indexList.get(firstBigger) - i;
                    }
                }
                pre += arr[i];
            }

            out.println(ans);
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
