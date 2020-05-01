package round634_div3;

import java.io.*;
import java.util.*;

public class E2 {

    static class Task {

//        private static final int MAX = 27;
        private static final int MAX = 201;
        private int[][] preCountArr;

        private void createPreCountArr(int[] arr, int n) {
            preCountArr = new int[MAX][n];
            for (int i = 0; i < MAX; i++) {
                if (arr[0] == i) {
                    preCountArr[i][0] = 1;
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (arr[i] == j) {
                        preCountArr[j][i] = preCountArr[j][i-1] + 1;
                    } else {
                        preCountArr[j][i] = preCountArr[j][i-1];
                    }
                }
            }
        }

        private int getMidMax(int[] arr, int l, int r) {
            if (l > r) {
                return 0;
            }

            int maxCount = 0;
            for (int i = 0; i < MAX; i++) {
                int count = preCountArr[i][r] - preCountArr[i][l - 1];
                maxCount = Math.max(maxCount, count);
            }

            return maxCount;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] arr = new int[n];
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                    set.add(arr[i]);
                }

                createPreCountArr(arr, n);

                // 先求一个数的最大情况
                int[] countArr = new int[MAX];
                List<Integer>[] indexListArr = new ArrayList[MAX];
                for (int i = 0; i < n; i++) {
                    countArr[arr[i]]++;
                    if (indexListArr[arr[i]] == null) {
                        indexListArr[arr[i]] = new ArrayList<>();
                    }
                    indexListArr[arr[i]].add(i);
                }

                int maxCount = 0;
                for (int i = 0; i < MAX; i++) {
                    maxCount = Math.max(maxCount, countArr[i]);
                }

                int ans = maxCount;
                // 遍历1-200
                for (Integer num : set) {
                    List<Integer> indexList = indexListArr[num];
                    int size = indexList.size();
                    if (size == 1) {
                        continue;
                    }

                    int left = 0;
                    int right = size - 1;
                    while (left < right) {
                        int leftIdx = indexList.get(left);
                        int rightIdx = indexList.get(right);
                        int midMaxCount = getMidMax(arr, leftIdx + 1, rightIdx - 1);
                        ans = Math.max(ans, (left + 1) * 2 + midMaxCount);
                        left++;
                        right--;
                    }
                }

                out.println(ans);
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
