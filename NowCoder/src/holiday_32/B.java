package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static long[][] colPreSumArr;
    private static int[][] grid;
    private static int rowCount;
    private static int colCount;

    private static boolean isOk(int fromR, int toR, int b, long target) {
        // 判断从fromR行到toR行垂直切割分成b块是否能够满足其中最小的快元素之和 <= target
        int colCount = grid[0].length;
        int fromC = 0;
        while (b > 0) {
            if (colCount - fromC < b) { // 剩余列数不够了
                return false;
            }

            boolean isFound = false;
            long sum = 0;
            for (int j = fromC; j < colCount; j++) {
                sum += fromR == 0 ? colPreSumArr[j][toR] : colPreSumArr[j][toR] - colPreSumArr[j][fromR - 1];
                if (sum >= target) {
                    isFound = true;
                    fromC = j + 1;
                    break;
                }
            }

            if (!isFound) {
                return false;
            }

            b--;
        }

        return true;
    }

    private static boolean isMatch(int a, int b, long target) {
        int fromR = 0;
        while (a > 0) {
            if (rowCount - fromR < a) {
                return false;
            }
            boolean isFound = false;
            for (int toRow = fromR; toRow < rowCount; toRow++) {
                if (isOk(fromR, toRow, b, target)) {
                    isFound = true;
                    fromR = toRow + 1;
                    break;
                }
            }

            if (!isFound) {
                return false;
            }

            a--;
        }

        return true;
    }

    private static void calcColPreSumArr() {
        colPreSumArr = new long[colCount][rowCount];
        for (int j = 0; j < colCount; j++) {
            colPreSumArr[j][0] = grid[0][j];
            for (int i = 1; i < rowCount; i++) {
                colPreSumArr[j][i] = colPreSumArr[j][i-1] + grid[i][j];
            }
        }
    }

    private static void solve() throws IOException {
        // 二分猜答案
        rowCount = nextInt();
        colCount = nextInt();
        int a = nextInt();
        int b = nextInt();
        grid = new int[rowCount][colCount];

        long sum = 0;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                grid[i][j] = nextInt();
                sum += grid[i][j];
            }
        }

        long low = 0;
        long high = sum;
        long ans = 0;
        calcColPreSumArr();

        while (low <= high) {
            long mid = (low + high) >>> 1L;
            if (isMatch(a, b, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }


    

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        solve();
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null)
                throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

}
