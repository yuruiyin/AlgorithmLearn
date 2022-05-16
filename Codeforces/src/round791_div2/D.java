package round791_div2;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private List<int[]> nodeList;
        private List<int[]>[] adj;

        private boolean isOk(int curIdx, long k, int maxValue, boolean[] visited) {
            if (k == 1 || visited[curIdx]) {
                return true;
            }

            visited[curIdx] = true;
            List<int[]> nextList = adj[curIdx];
            for (int[] next: nextList) {
                int nextIdx = next[0];
                int nextValue = next[1];
                if (nextValue > maxValue) {
                    continue;
                }
                if (isOk(nextIdx, k - 1, maxValue, visited)) {
                    return true;
                }
            }
            return false;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            long k = Math.max(in.nextLong(), n);
            nodeList = new ArrayList<>();
            int[][] map = new int[n + 1][2];
            for (int i = 0; i < n; i++) {
                int value = in.nextInt();
                int[] node =  new int[]{i + 1, value};
                nodeList.add(node);
                map[i + 1] = node;
            }

            adj = new ArrayList[n + 1];
            Arrays.setAll(adj, value -> new ArrayList<>());
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                adj[u].add(map[v]);
            }

            // 二分
            Collections.sort(nodeList, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int l = 0;
            int r = nodeList.size() - 1;
            long ansMin = Long.MAX_VALUE;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                int[] midNode = nodeList.get(mid);
                int midValue = midNode[1];
                boolean isFound = false;
                boolean[] visited = new boolean[n + 1];
                for (int i = 0; i <= mid; i++) {
                    int[] node = nodeList.get(i);
                    int curIdx = node[0];
                    if (isOk(curIdx, k, midValue, visited)) {
                        ansMin = midValue;
                        r = mid - 1;
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    l = mid + 1;
                }
            }
            out.println(ansMin == Long.MAX_VALUE ? -1 : ansMin);
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
