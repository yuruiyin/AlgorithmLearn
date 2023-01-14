package educational_round141;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
//            for (int n = 2; n <= 50; n++) {
            while ((t--) > 0) {
                int n = in.nextInt();
                // [1, n^2 - 1]
                int l = 1;
                int r = n * n - 1;
                int[][] grid = new int[n][n];
                grid[0][0] = 1;
                grid[1][0] = n * n;
                grid[0][1] = n * n - 1;
                boolean[] visited = new boolean[n * n + 1];
                visited[1] = true;
                visited[n * n] = true;
                visited[n * n - 1] = true;
                int[] dx = new int[]{-1, 1, 0, 0};
                int[] dy = new int[]{0, 0, -1, 1};
                boolean[] diffVisited = new boolean[n * n];
                diffVisited[n * n - 1] = true;
                diffVisited[n * n - 2] = true;
                for (int diff = n * n - 3; diff >= 1; diff--) {
                    if (diffVisited[diff]) {
                        continue;
                    }
                    boolean isFound = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (grid[i][j] != 0) {
                                continue;
                            }

                            for (int k = 0; k < 4; k++) {
                                int nextR = i + dx[k];
                                int nextC = j + dy[k];
                                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || grid[nextR][nextC] == 0) {
                                    continue;
                                }
                                int value = grid[nextR][nextC] - diff;
                                if (value <= n * n && value >= 1 && !visited[value]) {
                                    grid[i][j] = value;
                                    visited[value] = true;
                                    isFound = true;
                                    break;
                                }
                                value = grid[nextR][nextC] + diff;
                                if (value <= n * n && value >= 1 && !visited[value]) {
                                    grid[i][j] = value;
                                    visited[value] = true;
                                    isFound = true;
                                    break;
                                }
                            }

                            if (isFound) {
                                break;
                            }
                        }

                        if (isFound) {
                            break;
                        }
                    }

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            if (grid[i][j] == 0) {
                                continue;
                            }
                            for (int k = 0; k < 4; k++) {
                                int nextR = i + dx[k];
                                int nextC = j + dy[k];
                                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || grid[nextR][nextC] == 0) {
                                    continue;
                                }
                                diffVisited[Math.abs(grid[i][j] - grid[nextR][nextC])] = true;
                            }
                        }
                    }

//                    if (!isFound) {
//                        out.println("-------" + diff);
//                        out.println("------------------------------------");
//                    }
                }

                List<Integer> leftList = new ArrayList<>();
                for (int i = 2; i <= n * n; i++) {
                    if (!visited[i]) {
                        leftList.add(i);
                    }
                }

                int idx = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (grid[i][j] == 0) {
                            grid[i][j] = leftList.get(idx++);
                        }
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        out.print(grid[i][j] + " ");
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
