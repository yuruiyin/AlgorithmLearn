package round688_div2;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class C {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                char[][] grid = new char[n][n];
                List<int[]>[] indexListArr = new ArrayList[10];
                for (int i = 0; i < n; i++) {
                    grid[i] = in.next().toCharArray();
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        char c = grid[i][j];
                        if (indexListArr[c - '0'] == null) {
                            indexListArr[c - '0'] = new ArrayList<>();
                        }
                        indexListArr[c - '0'].add(new int[]{i, j});
                    }
                }

                int[] ansArr = new int[10];
                for (int i = 0; i <= 9; i++) {
                    List<int[]> indexList = indexListArr[i];
                    if (indexList == null || indexList.size() <= 1) {
                        ansArr[i] = 0;
                        continue;
                    }

                    int maxArea = 0;
                    int size = indexList.size();
                    for (int j = 0; j < size; j++) {
                        int[] pos1 = indexList.get(j);
                        int x1 = pos1[0];
                        int y1 = pos1[1];
                        for (int k = j + 1; k < size; k++) {
                            int[] pos2 = indexList.get(k);
                            int x2 = pos2[0];
                            int y2 = pos2[1];
                            int area = 0;
                            if (x1 == x2) {
                                area = Math.abs(y1 - y2) * Math.max(x1, n - 1 - x1);
                                maxArea = Math.max(maxArea, area);
                            } else if (y1 == y2) {
                                area = Math.abs(x1 - x2) * Math.max(y1, n - 1 - y1);
                                maxArea = Math.max(maxArea, area);
                            } else {
                                int area1 = Math.abs(x1 - x2) * Math.max(y1, n - 1 - y1);
                                int area2 = Math.abs(y1 - y2) * Math.max(x1, n - 1 - x1);
                                int area3 = Math.abs(x1 - x2) * Math.max(y2, n - 1 - y2);
                                int area4 = Math.abs(y1 - y2) * Math.max(x2, n - 1 - x2);
                                maxArea = Math.max(maxArea, Math.max(Math.max(area1, area2), Math.max(area3, area4)));
                            }
                        }
                    }

                    ansArr[i] = maxArea;
                }

                for (int i = 0; i <= 9; i++) {
                    out.print(ansArr[i] + " ");
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
