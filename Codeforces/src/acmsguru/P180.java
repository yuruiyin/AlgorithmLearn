package acmsguru;

import java.io.*;
import java.util.StringTokenizer;

public class P180 {

    static class Task {

        private int[] tmpArr;

        // 合并的时候计算逆序数
        private long merge(int[] arr, int l, int mid, int r) {
            int size = 0;
            long reverseCount = 0;
            int i, j;
            for (i = l, j = mid + 1; i <= mid && j <= r;) {
                if (arr[i] <= arr[j]) {
                    tmpArr[size] = arr[i];
                    i++;
                } else {
                    tmpArr[size] = arr[j];
                    j++;
                    reverseCount += mid - i + 1; // 关键是这里
                }
                size++;
            }

            while (i <= mid) {
                tmpArr[size++] = arr[i++];
            }

            while (j <= r) {
                tmpArr[size++] = arr[j++];
            }

            for (int k = 0; k < size; k++) {
                arr[l + k] = tmpArr[k];
            }

            return reverseCount;
        }

        private long mergeSort(int[] arr, int l, int r) {
            if (l == r) {
                return 0;
            }

            int mid = (l + r) >>> 1;
            long leftCount = mergeSort(arr, l, mid);
            long rightCount =  mergeSort(arr, mid + 1, r);
            if (arr[mid] <= arr[mid + 1]) {
                return leftCount + rightCount;
            }
            // merge
            long mergeCount = merge(arr, l, mid, r);
            return leftCount + rightCount + mergeCount;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            // 计算每个数前面有多少个比他大的元素
            tmpArr = new int[n];
            long ans = mergeSort(arr, 0, n - 1);
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
