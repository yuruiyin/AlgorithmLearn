package round633_div2;

import java.io.*;
import java.util.*;

public class D {

    static class Task {
        private int n;

        private boolean hasOddDis(List<Integer>[] adj, int from, Set<Integer> leafSet) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(from);
            boolean[] visited = new boolean[n + 1];
            visited[from] = true;
            int dis = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                dis++;
                for (int i = 0; i < size; i++) {
                    int cur = queue.poll();
                    List<Integer> nextList = adj[cur];
                    for (Integer next: nextList) {
                        if (visited[next]) {
                            continue;
                        }

                        if (dis % 2 == 1 && leafSet.contains(next)) {
                            return true;
                        }

                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

            return false;
        }

        private List<Integer> getTwoDisLeafList(List<Integer>[] adj, int from, Set<Integer> leafSet) {
            List<Integer> nextList = adj[from];
            List<Integer> ansList = new ArrayList<>(); // 与from距离为2的叶子节点
            for (Integer next: nextList) {
                List<Integer> nextNextList = adj[next];
                for (Integer nextNext: nextNextList) {
                    if (nextNext == from) {
                        continue;
                    }

                    if (leafSet.contains(nextNext)) {
                        ansList.add(nextNext);
                    }
                }
            }
            return ansList;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            n = in.nextInt();
            List<Integer>[] adj = new ArrayList[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                if (adj[v1] == null) {
                    adj[v1] = new ArrayList<>();
                }
                adj[v1].add(v2);

                if (adj[v2] == null) {
                    adj[v2] = new ArrayList<>();
                }
                adj[v2].add(v1);
            }

            // 求所有的叶子节点
            Set<Integer> leafSet = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                if (adj[i] != null && adj[i].size() == 1) {
                    leafSet.add(i);
                }
            }

            boolean[] leafVisited = new boolean[n + 1];

            // 判断有多少对两个叶子节点距离为2，距离为2说明需要权值只能取一样的
            List<Integer> list = new ArrayList<>();
            int towDisEdgeCount = 0;
            for (Integer leaf : leafSet) {
                if (leafVisited[leaf]) {
                    continue;
                }

                leafVisited[leaf] = true;
                List<Integer> twoDisLeafList = getTwoDisLeafList(adj, leaf, leafSet);
                if (twoDisLeafList.isEmpty()) {
                    continue;
                }

                for (Integer tmpLeaf : twoDisLeafList) {
                    leafVisited[tmpLeaf] = true;
                }

                int leafSize = twoDisLeafList.size();
                list.add(leafSize + 1);
                towDisEdgeCount += leafSize + 1;
            }

            Iterator<Integer> leafIterator = leafSet.iterator();
            int min = 1;
            int max = n - 1 - towDisEdgeCount + list.size();
            if (hasOddDis(adj, leafIterator.next(), leafSet)) {
                // 有奇数距离的路径
                min = 3;
            }
//            max = Math.max(max, min);
            out.println(min + " " + max);
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
