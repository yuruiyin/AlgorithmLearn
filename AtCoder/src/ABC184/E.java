package ABC184;

import java.io.*;
import java.util.*;

public class E {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private int[] getPos(char[][] grid, int m, int n, char c) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == c) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public List<int[]>[] getLetterPosList(char[][] grid, int m, int n) {
            List<int[]>[] letterPosList = new ArrayList[26];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char c = grid[i][j];
                    if (c >= 'a' && c <= 'z') {
                        if (letterPosList[c - 'a'] == null) {
                            letterPosList[c - 'a'] = new ArrayList<>();
                        }

                        letterPosList[c - 'a'].add(new int[]{i, j});
                    }
                }
            }
            return letterPosList;
        }

        private int[] dx = new int[]{-1, 1, 0, 0};
        private int[] dy = new int[]{0, 0, -1, 1};

        private int bfs(char[][] grid, int m, int n) {
            int[] sPos = getPos(grid, m, n, 'S');
            int[] gPos = getPos(grid, m, n, 'G');

            List<int[]>[] letterPosList = getLetterPosList(grid, m, n);
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(sPos);
            boolean[][] visited = new boolean[m][n];
            visited[sPos[0]][sPos[1]] = true;
            boolean[] letterVisited = new boolean[26];
            int ans = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] node = queue.poll();
                    int curRow = node[0];
                    int curCol = node[1];
                    if (curRow == gPos[0] && curCol == gPos[1]) {
                        return ans;
                    }

                    for (int j = 0; j < 4; j++) {
                        int nextRow = curRow + dx[j];
                        int nextCol = curCol + dy[j];
                        if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol] || grid[nextRow][nextCol] == '#') {
                            continue;
                        }

                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol});
                    }

                    if (grid[curRow][curCol] >= 'a' && grid[curRow][curCol] <= 'z' && !letterVisited[grid[curRow][curCol] - 'a']) {
                        List<int[]> posList = letterPosList[grid[curRow][curCol] - 'a'];
                        for (int[] tmpPos : posList) {
                            int nextRow = tmpPos[0];
                            int nextCol = tmpPos[1];
                            if (visited[nextRow][nextCol]) {
                                continue;
                            }
                            visited[nextRow][nextCol] = true;
                            queue.add(new int[]{nextRow, nextCol});
                        }
                        letterVisited[grid[curRow][curCol] - 'a'] = true;
                    }
                }
                ans++;
            }

            return -1;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int m = in.nextInt();
            int n = in.nextInt();
            char[][] grid = new char[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = in.next().toCharArray();
            }

            int ans = bfs(grid, m, n);
            out.println(ans);
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
