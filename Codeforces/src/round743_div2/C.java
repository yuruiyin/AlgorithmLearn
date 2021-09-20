package round743_div2;

import java.io.*;
import java.util.*;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private void dfs(List<Integer>[] adj, int[] inDegree, int cur) {
            List<Integer> nextList = adj[cur];
            if (nextList == null) {
                return;
            }

            for (int next: nextList) {
                if (next > cur) {
                    
                }
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                List<Integer>[] adj = new ArrayList[n + 1];

                for (int i = 1; i <= n; i++) {
                    int k = in.nextInt();
                    for (int j = 0; j < k; j++) {
                        int a = in.nextInt();
                        if (adj[a] == null) {
                            adj[a] = new ArrayList<>();
                        }
                        adj[a].add(i);
                    }
                }

                int[] inDegree = new int[n + 1];
                for (int i = 1; i <= n; i++) {
                    if (adj[i] == null) {
                        continue;
                    }
                    for (Integer next: adj[i]) {
                        inDegree[next]++;
                    }
                }

                LinkedList<Integer> zeroInDegreeNodeList = new LinkedList<>();
                for (int i = 1; i <= n; i++) {
                    if (inDegree[i] == 0) {
                        zeroInDegreeNodeList.add(i);
                    }
                }

                int ans = 0;
                int count = 0;

                while (!zeroInDegreeNodeList.isEmpty()) {
                    int size = zeroInDegreeNodeList.size();
                    count += size;
                    for (int i = 0; i < size; i++) {
                        int cur = zeroInDegreeNodeList.pollFirst();
                        List<Integer> nextList = adj[cur];
                        if (nextList == null) {
                            continue;
                        }

                        // 先dfs删除上升路径


                        for (int next: nextList) {
                            inDegree[next]--;
                            if (inDegree[next] == 0) {
                                zeroInDegreeNodeList.add(next);
                            } else if (cur < next) {

                            }
                        }
                    }
                    ans++;
                }

                if (count != n) {
                    out.println(-1);
                } else {
                    out.println(ans);
                }

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
