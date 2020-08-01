package round02;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static class Task {

        private static final long MOD = (int) (1e9+7);

        private int[] arr;
        private int n;

        private int getMin(int l, int r) {
            int min = Integer.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        private long rec(int l, int r) {
            int min = getMin(l, r);
            for (int i = l; i <= r; i++) {
                arr[i] -= min;
            }

            return ((r - l + 1L) * (r - l + 1L) * min + getMaxCost(l, r)) % MOD;
        }

        private long getMaxCost(int start, int end) {
            // 最大代价
            long maxCost = 0;
            int l = -1;
            for (int i = start; i <= end; i++) {
                if (arr[i] != 0) {
                    l = i;
                    break;
                }
            }

            if (l == -1) {
                return 0;
            }

            for (int i = l + 1; i <= end;) {
                if (arr[i] == 0) {
                    maxCost = (maxCost + rec(l, i - 1)) % MOD;
                    int j;
                    for (j = i + 1; j <= end; j++) {
                        if (arr[j] != 0) {
                            l = j;
                            break;
                        }
                    }

                    if (j == end + 1) {
                        break; // 后面都是0
                    }

                    i = Math.max(i + 1, l + 1);
                } else {
                    i++;
                }
            }

            if (arr[end] != 0) {
                maxCost = (maxCost + rec(l , end)) % MOD;
            }

            return maxCost;
        }

        private long getAns(int l, int r) {
            long ans = 0;
            List<Integer> indexList = new ArrayList<>();
            indexList.add(l);
            for (int i = l + 1; i <= r; i++) {
                if (arr[i] > arr[i-1]) {
                    indexList.add(i);
                }
            }

            int preSum = 0;
            long size = r - l + 1;
            for (int index : indexList) {
                ans = (ans + (size - index + l) * (size - index + l) * (arr[index] - preSum)) % MOD;
                preSum += arr[index];
            }

            return ans;
        }

        private long getMinCost() {
            long l = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] != 0) {
                    l = i;
                    break;
                }
            }

            if (l == -1) {
                return 0;
            }

            long minCost = 0;
            for (int i = (int) (l + 1); i < n; i++) {
                if (arr[i] == 0) {
                    minCost = (minCost + getAns((int) l, i - 1)) % MOD;
                    continue;
                }

                if (arr[i] < arr[i-1]) {
                    while (arr[i] < arr[i - 1]) {
                        long minDiff = Math.min(arr[(int) l], arr[i - 1] - arr[i]);
                        minCost = (minCost + minDiff * (i - l) * (i - l)) % MOD;
                        for (int j = (int) l; j < i; j++) {
                            if (arr[j] == minDiff) {
                                l++;
                                arr[j] = 0;
                            } else {
                                arr[j] -= minDiff;
                            }
                        }
                    }
                }
            }

            if (arr[n - 1] != 0) {
                minCost = (minCost + getAns((int) l, n - 1)) % MOD;
            }

            return minCost;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            // 最大代价就是每次寻找最大的连续的非0区间
            // 最小代价就是不断找最大的非降序
            n = in.nextInt();
            arr = new int[n];
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                arr1[i] = arr[i];
            }

            long maxCost = getMaxCost(0, n - 1);
            if (maxCost == 0) {
                out.println("0 0");
                return;
            }

            arr = arr1;
            long minCost = getMinCost();
            out.println(minCost + " " + maxCost);
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
