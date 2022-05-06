package round787_div3;

import java.io.*;
import java.util.*;

public class D {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private List<Integer>[] adj;

        private List<LinkedList<Integer>> dfs(int cur) {
            List<Integer> nextList = adj[cur];
            if (nextList == null || nextList.isEmpty()) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(cur);
                return new ArrayList<>(Collections.singleton(list));
            }

            List<LinkedList<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < nextList.size(); i++) {
                int next = nextList.get(i);
                List<LinkedList<Integer>> res = dfs(next);
                if (i == 0) {
                    // 将当前节点与第一条路径进行相加
                    LinkedList<Integer> firstPath = res.get(0);
                    firstPath.addFirst(cur);
                }
                ans.addAll(res);
            }
            return ans;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int[] parents = new int[n];
                for (int i = 0; i < n; i++) {
                    parents[i] = in.nextInt();
                }

                int root = -1;
                adj = new ArrayList[n + 1];
                Arrays.setAll(adj, value -> new ArrayList<>());
                for (int i = 0; i < n; i++) {
                    int son = i + 1;
                    int parent = parents[i];
                    if (son == parent) {
                        root = son;
                        continue;
                    }
                    adj[parent].add(son);
                }

                List<LinkedList<Integer>> ansPaths = dfs(root);
                out.println(ansPaths.size());
                for (LinkedList<Integer> paths: ansPaths) {
                    out.println(paths.size());
                    for (int node : paths) {
                        out.print(node + " ");
                    }
                    out.println();
                }
                out.println();
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
