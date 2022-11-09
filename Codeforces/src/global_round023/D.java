package global_round023;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    // 注意不要使用System.out.println
    static class Task {

        private List<Integer>[] adj;

        private List<Long> pathSumList;

        private long[] s;

        private void dfs(int cur, long preSum) {
            List<Integer> nextList = adj[cur];
            preSum += s[cur - 1];
            if (nextList.isEmpty()) {
                // 叶子
                pathSumList.add(preSum);
                return;
            }

            for (int next : nextList) {
                dfs(next, preSum);
            }
        }

        private long rec(int cur, int k, List<Integer>[] maxIdxArr) {
            if (k <= 0) {
                return 0;
            }
            List<Integer> nextList = maxIdxArr[cur];
            long sum = s[cur - 1] * k;
            if (nextList.isEmpty()) {
                return sum;
            }

            int size = nextList.size();
            int each = k / size;
            int mod = k % size;

            for (int next : nextList) {
                if (mod >= 1) {
                    sum += rec(next, each + 1, maxIdxArr);
                    mod--;
                } else {
                    sum += rec(next, each, maxIdxArr);
                }
            }

            return sum;
        }

        private long maxRec(int cur, List<Integer>[] maxIdxListArr) {
            List<Integer> nextList = adj[cur];
            if (nextList.isEmpty()) {
                return s[cur - 1];
            }
            long maxSum = 0;
            PriorityQueue<long[]> heap = new PriorityQueue<>(new Comparator<long[]>() {
                @Override
                public int compare(long[] o1, long[] o2) {
                    return Long.compare(o2[0], o1[0]);
                }
            });
            for (int next : nextList) {
                long tmpSum = maxRec(next, maxIdxListArr);
                if (tmpSum > maxSum) {
                    maxSum = tmpSum;
                }
                heap.add(new long[]{tmpSum, next});
            }
            List<Integer> idxList = new ArrayList<>();
            while (!heap.isEmpty()) {
                long[] top = heap.poll();
//                System.out.print("sum: " + top[0] + " ");
                idxList.add((int) top[1]);
            }
//            System.out.println();
            maxIdxListArr[cur] = idxList;
            return maxSum + s[cur - 1];
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int k = in.nextInt();
                adj = new ArrayList[n + 1];
                Arrays.setAll(adj, value -> new ArrayList<>());
//                int[] parent = new int[n + 1];
//                parent[1] = -1;
                for (int i = 2; i <= n; i++) {
                    int p = in.nextInt();
                    adj[p].add(i);
                }

                s = new long[n];
                for (int i = 0; i < n; i++) {
                    s[i] = in.nextInt();
                }

                // 求根节点到叶子节点的所有路径之和， 类似 3,3,2,2,2,2,...,2
                pathSumList = new ArrayList<>();
                dfs(1, 0);
                Collections.sort(pathSumList);
                int size = pathSumList.size();
                int each = k / size;
                int mod = k % size;
                long ans = 0;
//                for (long pathSum : pathSumList) {
//                    ans += each * pathSum;
//                }
                List<Integer>[] maxIdxArr = new ArrayList[n + 1];
                Arrays.setAll(maxIdxArr, value -> new ArrayList<>());
                maxRec(1, maxIdxArr);
                ans += rec(1, k, maxIdxArr);
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
