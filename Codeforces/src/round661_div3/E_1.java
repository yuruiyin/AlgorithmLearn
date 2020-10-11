package round661_div3;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class E_1 {

    static class Task {

        private long MAX = 100005;

        private List<Integer>[] adj;
        private long s;
        private int n;
        private Map<Long, Integer> wMap;
        private int[] leafCountArr;
        private Set<Integer>[] nextListArr;

        private int dfs(int cur, boolean[] visited) {
            visited[cur] = true;
            List<Integer> nextList = adj[cur];
            int leafCount = 0;
            Set<Integer> newNextList = new HashSet<>();
            for (Integer next : nextList) {
                if (visited[next]) {
                    continue;
                }

                leafCount += dfs(next, visited);
                newNextList.add(next);
            }

            nextListArr[cur] = newNextList;

            if (leafCount == 0) {
                leafCountArr[cur] = 1;
                return 1;
            }

            leafCountArr[cur] = leafCount;
            return leafCount;
        }

        private long getSum(int cur, boolean[] visited) {
            visited[cur] = true;
            List<Integer> nextList = adj[cur];
            long sum = 0;
            for (Integer next : nextList) {
                if (visited[next]) {
                    continue;
                }

                // edge ： cur -> next
                long weight = wMap.get(cur * MAX + next);
                sum += weight * leafCountArr[next] + getSum(next, visited);
            }

            return sum;
        }

        class Edge {
            int u;
            int v;
            long w;
            int childNode;
            Edge(int u, int v, long w) {
                this.u = u;
                this.v = v;
                this.w = w;
            }
        }

        private void calcEdgeChildNode(List<Edge> edgeList) {
            for (Edge edge : edgeList) {
                edge.childNode = getChildNode(edge);
            }
        }

        private int getChildNode(Edge edge) {
            if (nextListArr[edge.u] != null && nextListArr[edge.u].contains(edge.v)) {
                return edge.v;
            }
            return edge.u;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                n = in.nextInt();
                s = in.nextLong();
                adj = new ArrayList[n + 1];
                wMap = new HashMap<>();
                List<Edge> edgeList = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    int u = in.nextInt();
                    int v = in.nextInt();
                    int w = in.nextInt();
                    edgeList.add(new Edge(u, v, w));
                    if (adj[u] == null) {
                        adj[u] = new ArrayList<>();
                    }
                    adj[u].add(v);

                    if (adj[v] == null) {
                        adj[v] = new ArrayList<>();
                    }
                    adj[v].add(u);

                    wMap.put(u * MAX + v, w);
                    wMap.put(v * MAX + u, w);
                }

                // 求每个节点为子树的叶子节点的个数
                leafCountArr = new int[n + 1];
                nextListArr = new HashSet[n + 1];
                dfs(1, new boolean[n + 1]);

                // 求所有root到leaf的sum
                long totalSum = getSum(1, new boolean[n + 1]);

                if (totalSum <= s) {
                    out.println(0);
                    continue;
                }

                PriorityQueue<Edge> heap = new PriorityQueue<>(new Comparator<Edge>() {
                    @Override
                    public int compare(Edge o1, Edge o2) {
                        long value1 = ((o1.w + 1) >>> 1) * leafCountArr[o1.childNode];
                        long value2 = ((o2.w + 1) >>> 1) * leafCountArr[o2.childNode];
                        return Long.compare(value2, value1);
                    }
                });

                calcEdgeChildNode(edgeList);

                for (Edge edge : edgeList) {
                    heap.offer(edge);
                }

                long ans = 0;
                while (!heap.isEmpty() && totalSum > s) {
                    Edge edge = heap.poll();
                    totalSum -= ((edge.w + 1) >>> 1) * leafCountArr[getChildNode(edge)];
                    edge.w >>>= 1;
                    heap.offer(edge);
                    ans++;
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
