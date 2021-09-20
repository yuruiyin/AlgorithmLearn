package educational_round115;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private Set<String> set;
        private List<Integer>[] listArr;
        private int n;
        private Map<String, int[]> memoMap;

        private String arr2String(int[] indexArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int curIdx = indexArr[i];
                sb.append(curIdx);
                sb.append(",");
            }
            return sb.toString();
        }

        private int getSum(int[] indexArr) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += listArr[i].get(indexArr[i] - 1);
            }
            return sum;
        }

        private int[] dp(int[] indexArr) {
            String key = arr2String(indexArr);
            if (!set.contains(key)) {
                return Arrays.copyOf(indexArr, n);
            }

            if (memoMap.containsKey(key)) {
                return memoMap.get(key);
            }

            // 如果当前indexArr不合法，则往左遍历
            int[] ansIndexArr = new int[n];
            int ansMaxSum = 0;
            for (int i = 0; i < n; i++) {
                if (indexArr[i] <= 1) {
                    continue;
                }
                indexArr[i]--;
                int[] tmpIndexArr = dp(indexArr);
                if (tmpIndexArr == null) {
                    indexArr[i]++;
                    continue;
                }

                int sum = getSum(tmpIndexArr);
                if (sum > ansMaxSum) {
                    ansMaxSum = sum;
                    ansIndexArr = tmpIndexArr;
                }
                indexArr[i]++;
            }

            if (ansMaxSum == 0) {
                memoMap.put(key, null);
                return null;
            }

            memoMap.put(key, ansIndexArr);
            return ansIndexArr;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            listArr = new ArrayList[n];
            int[] indexArr = new int[n];
            for (int i = 0; i < n; i++) {
                int c = in.nextInt();
                listArr[i] = new ArrayList<>();
                for (int j = 0; j < c; j++) {
                    listArr[i].add(in.nextInt());
                }
                indexArr[i] = c;
            }

            int m = in.nextInt();
            set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(in.nextInt());
                    sb.append(",");
                }
                set.add(sb.toString());
            }

            memoMap = new HashMap<>();
            int[] ansArr = dp(indexArr);
            for (int i = 0; i < n; i++) {
                out.print(ansArr[i] + " ");
            }
            out.println();
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
