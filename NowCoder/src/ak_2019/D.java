package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        int t = nextInt();
        int[][] grid = new int[n][m];
        int[][] arr = new int[t][2];
        for (int i = 0; i < t; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
        }

        boolean[] rowVisited = new boolean[n];
        boolean[] colVisited = new boolean[m];

        for (int i = t - 1; i >= 0; i--) {
            int flag = arr[i][0];
            int num = arr[i][1];
            if (flag == 1) {
                int row = num - 1;
                if (rowVisited[row]) {
                    continue;
                }
                rowVisited[row] = true;
                for (int col = 0; col < m; col++) {
                    if (colVisited[col]) {
                        continue;
                    }
                    grid[row][col] = i+1;
                }
            } else {
                int col = num - 1;
                if (colVisited[col]) {
                    continue;
                }
                colVisited[col] = true;
                for (int row = 0; row < n; row++) {
                    if (rowVisited[row]) {
                        continue;
                    }
                    grid[row][col] = i + 1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
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
