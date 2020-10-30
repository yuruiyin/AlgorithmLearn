package AGC048;

import java.io.*;
import java.util.*;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private Map<Long, Long> memoMap;
        private int n;
        private long[] arr1;
        private long[] arr2;
        private long[] maxArr;

        private long dp(int l, int r) {
            if (l > r) {
                return 0;
            }

            if (l + 1 == r) {
                return maxArr[l];
            }

            long key = ((long) l) * n + r;
            if (memoMap.containsKey(key)) {
                return memoMap.get(key);
            }

//            long ansMax = 0;
//            long maxEndNum1 = 0;
//            int maxEndIdx1 = -1;
//            for (int end = l + 1; end <= r; end+=2) {
//                if (arr1[end] > maxEndNum1) {
//                    maxEndNum1 = arr1[end];
//                    maxEndIdx1 = end;
//                }
//            }
//
//            long maxEndNum2 = 0;
//            int maxEndIdx2 = -1;
//            for (int end = l + 1; end <= r; end+=2) {
//                if (arr2[end] > maxEndNum2) {
//                    maxEndNum2 = arr2[end];
//                    maxEndIdx2 = end;
//                }
//            }
//
//            long minEndNum1 = Long.MAX_VALUE;
//            int minEndIdx1 = -1;
//            for (int end = l + 1; end <= r; end+=2) {
//                if (arr1[end] < minEndNum1) {
//                    minEndNum1 = arr1[end];
//                    minEndIdx1 = end;
//                }
//            }
//
//            long minEndNum2 = Long.MAX_VALUE;
//            int minEndIdx2 = -1;
//            for (int end = l + 1; end <= r; end+=2) {
//                if (arr2[end] < minEndNum2) {
//                    minEndNum2 = arr2[end];
//                    minEndIdx2 = end;
//                }
//            }
//
//            long res1 = arr1[l] + arr1[maxEndIdx1] + dp(l + 1, maxEndIdx1 - 1) + dp(maxEndIdx1 + 1, r);
//            long res2 = arr2[l] + arr2[maxEndIdx2] + dp(l + 1, maxEndIdx2 - 1) + dp(maxEndIdx2 + 1, r);
//            long res3 = arr1[l] + arr1[minEndIdx1] + dp(l + 1, minEndIdx1 - 1) + dp(minEndIdx1 + 1, r);
//            long res4 = arr2[l] + arr2[minEndIdx2] + dp(l + 1, minEndIdx2 - 1) + dp(minEndIdx2 + 1, r);
//            ansMax =  Math.max(Math.max(res1, res2), Math.max(res3, res4));

            long ansMax = 0;
            for (int end = r; end >= l + 1; end-=2) {
                long res = Math.max(arr1[l] + arr1[end], arr2[l] + arr2[end]) + dp(l + 1, end - 1) + dp(end + 1, r);
                ansMax = Math.max(ansMax, res);
            }

            memoMap.put(key, ansMax);
            return ansMax;
        }

        private void createInput(long[] arr1, long[] arr2) {
            Random random = new Random();
            int N = (int) 1e9;
            for (int i = 0; i < 1000; i++) {
                arr1[i] = random.nextInt(N);
                System.out.print(arr1[i] + " ");
            }
            
            System.out.println();

            for (int i = 0; i < 1000; i++) {
                arr2[i] = random.nextInt(N);
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.n = in.nextInt();
            arr1 = new long[n];
            arr2 = new long[n];
//            createInput(arr1, arr2);
            for (int i = 0; i < n; i++) {
                arr1[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr2[i] = in.nextInt();
            }

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }

            long ansMax = 0;

            while (!list.isEmpty()) {
                int size = list.size();
                int maxPairIdx = -1;
                long maxPairSum = 0;
                for (int i = 0; i < size - 1; i++) {
                    int firstIdx = list.get(i);
                    int secondIdx = list.get(i + 1);
                    long tmpMax = Math.max(arr1[firstIdx] + arr1[secondIdx], arr2[firstIdx] + arr2[secondIdx]);
                    if (tmpMax > maxPairSum) {
                        maxPairSum = tmpMax;
                        maxPairIdx = i;
                    }
                }

                ansMax += maxPairSum;
                list.remove(maxPairIdx);
                list.remove(maxPairIdx);
            }

//            maxArr = new long[n];
//            for (int i = 0; i < n - 1; i++) {
//                maxArr[i] = Math.max(arr1[i] + arr1[i + 1], arr2[i] + arr2[i + 1]);
//            }
//
//            memoMap = new HashMap<>();
//            long ans = dp(0, n - 1);
            out.println(ansMax);
        }
    }

    private static void sort(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(double[] arr) {
        Double[] objArr = Arrays.stream(arr).boxed().toArray(Double[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(int[] arr) {
        Integer[] objArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
        }
    }

    private static void sort(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[i];
        }
    }

    private static void sortDesc(long[] arr) {
        Long[] objArr = Arrays.stream(arr).boxed().toArray(Long[]::new);
        Arrays.sort(objArr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objArr[arr.length - i - 1];
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
