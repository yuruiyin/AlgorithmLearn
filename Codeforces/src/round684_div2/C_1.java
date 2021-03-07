package round684_div2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C_1 {

    // 注意不要用Arrays.sort()
    // 注意Math.pow可能导致精度问题
    // 注意int溢出问题
    static class Task {

        private List<int[]> getAns2(List<int[]> onePosList, List<int[]> zeroPosList) {
            List<int[]> ansList = new ArrayList<>();
            int[] onePos1 = onePosList.get(0);
            ansList.add(new int[]{onePos1[0], onePos1[1], zeroPosList.get(0)[0], zeroPosList.get(0)[1], zeroPosList.get(1)[0], zeroPosList.get(1)[1]});
            int[] onePos2 = onePosList.get(1);
            ansList.add(new int[]{onePos2[0], onePos2[1], zeroPosList.get(0)[0], zeroPosList.get(0)[1], zeroPosList.get(1)[0], zeroPosList.get(1)[1]});
            return ansList;
        }

        private void setToZero(char[][] grid, int x, int y) {
            grid[x][y] = '0';
            grid[x][y + 1] = '0';
            grid[x + 1][y] = '0';
            grid[x + 1][y + 1] = '0';
        }

        private List<int[]> getAns(char[][] grid, int x, int y) {
            if (x < grid.length - 2 && y < grid[0].length - 2 && grid[x][y] == '0') {
                return null;
            }
            int oneCount = 0;
            List<int[]> onePosList = new ArrayList<>();
            List<int[]> zeroPosList = new ArrayList<>();
            for (int i = x; i <= x + 1; i++) {
                for (int j = y; j <= y + 1; j++) {
                    if (grid[i][j] == '1') {
                        oneCount++;
                        onePosList.add(new int[]{i, j});
                    } else {
                        zeroPosList.add(new int[]{i, j});
                    }
                }
            }

            List<int[]> ansList = new ArrayList<>();
            switch (oneCount) {
                case 0:
                    return null;
                case 1:
                    int[] tmpOnePos = onePosList.get(0);
                    ansList.add(new int[]{tmpOnePos[0], tmpOnePos[1], zeroPosList.get(0)[0], zeroPosList.get(0)[1], zeroPosList.get(1)[0], zeroPosList.get(1)[1]});
                    grid[tmpOnePos[0]][tmpOnePos[1]] = '0';
                    grid[zeroPosList.get(0)[0]][zeroPosList.get(0)[1]] = '1';
                    grid[zeroPosList.get(1)[0]][zeroPosList.get(1)[1]] = '1';
                    List<int[]> onePosList1 = new ArrayList<>();
                    List<int[]> zeroPosList1 = new ArrayList<>();
                    for (int i = x; i <= x + 1; i++) {
                        for (int j = y; j <= y + 1; j++) {
                            if (grid[i][j] == '1') {
                                onePosList1.add(new int[]{i, j});
                            } else {
                                zeroPosList1.add(new int[]{i, j});
                            }
                        }
                    }
                    ansList.addAll(getAns2(onePosList1, zeroPosList1));
                    setToZero(grid, x, y);
                    return ansList;
                case 2:
                    ansList = getAns2(onePosList, zeroPosList);
                    setToZero(grid, x, y);
                    return ansList;
                case 3:
                    int[] ansArr = new int[6];
                    int idx = 0;
                    for (int[] onePos : onePosList) {
                        ansArr[idx++] = onePos[0];
                        ansArr[idx++] = onePos[1];
                        grid[onePos[0]][onePos[1]] = '0';
                    }

                    ansList.add(ansArr);
                    return ansList;
                case 4:
                    if (x == grid.length - 2 && y == grid[0].length - 2) {
                        // 最后一个全1，需要处理
                        ansList.add(new int[]{x, y, x, y + 1, x + 1, y});
                        ansList.add(new int[]{x, y, x + 1, y, x + 1, y + 1});
                        ansList.add(new int[]{x, y, x, y + 1, x + 1, y + 1});
                        ansList.add(new int[]{x, y + 1, x + 1, y, x + 1, y + 1});
                    } else {
                        ansList.add(new int[]{x, y, x, y + 1, x + 1, y});
                        grid[x][y] = '0';
                        grid[x][y + 1] = '0';
                        grid[x + 1][y] = '0';
                    }
                    return ansList;
            }

            return null;
        }

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int t = in.nextInt();
            while ((t--) > 0) {
                int n = in.nextInt();
                int m = in.nextInt();
                char[][] grid = new char[n][m];
                for (int i = 0; i < n; i++) {
                    grid[i] = in.next().toCharArray();
                }

                List<int[]> ansList = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    for (int j = 0; j < m - 1; j++) {
                        List<int[]> posArr = getAns(grid, i, j);
                        if (posArr != null) {
                            ansList.addAll(posArr);
                        }
                    }
                }

                out.println(ansList.size());
                for (int[] pos : ansList) {
                    for (int num : pos) {
                        out.print((num + 1) + " ");
                    }
                    out.println();
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
