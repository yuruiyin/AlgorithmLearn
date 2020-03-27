package round629_div3;

import java.io.*;
import java.util.*;

public class E {

    static class Task {

        private List<List<Integer>> pathList;
        private Set<Integer>[] adj;
        private Map<Integer, List<Set<Integer>>> map;

        private void dfs(int cur, List<Integer> tmpList, boolean[] visited) {
            Set<Integer> nextList = adj[cur];
            boolean hasNext = false;
            for (Integer next : nextList) {
                if (visited[next]) {
                    continue;
                }

                visited[cur] = true;
                tmpList.add(next);
                dfs(next, tmpList, visited);
                tmpList.remove(tmpList.size() - 1);
                visited[cur] = false;
                hasNext = true;
            }

            if (!hasNext) {
                // 叶子
                Set<Integer> path = new HashSet<>(tmpList);
                for (Integer node : path) {
                    if (map.containsKey(node)) {
                        map.get(node).add(path);
                    } else {
                        List<Set<Integer>> listlist = new ArrayList<>();
                        listlist.add(path);
                        map.put(node, listlist);
                    }
                }
//                pathList.add(new ArrayList<>(tmpList));
            }
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            adj = new HashSet[n + 1];
            for (int i = 0; i < n - 1; i++) {
                int v1 = in.nextInt();
                int v2 = in.nextInt();
                if (adj[v1] == null) {
                    adj[v1] = new HashSet<>();
                }
                adj[v1].add(v2);

                if (adj[v2] == null) {
                    adj[v2] = new HashSet<>();
                }
                adj[v2].add(v1);
            }

            map = new HashMap<>();
            pathList = new ArrayList<>();
            boolean[] visited = new boolean[n + 1];
            visited[1] = true;
            dfs(1, new ArrayList<>(), visited);

            while ((m--) > 0) {
                int k = in.nextInt();
                int[] arr = new int[k];
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < k; i++) {
                    arr[i] = in.nextInt();
                    set.add(arr[i]);
                }

                List<Set<Integer>> pathList = map.get(arr[0]);
                for (Set<Integer> path : pathList) {
                    boolean isOk1 = true;
                    for (Integer node1 : set) {
                        if (path.contains(node1)) {
                            continue;
                        }

                        boolean isOk = false;
                        for (Integer next : adj[node1]) {
                            if (path.contains(next)) {
                                isOk = true;
                                break;
                            }
                        }

                        if (!isOk) {
                            isOk1 = false;
                            break;
                        }
                    }

                    if (isOk1) {
                        out.println("YES");
                        break;
                    }
                }

                out.println("NO");
            }
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
