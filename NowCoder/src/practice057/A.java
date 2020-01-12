package practice057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            String[] arr = new String[3];
            for (int i = 0; i < 3; i++) {
                arr[i] = next();
            }

            char[][] grid = new char[3][3];
            for (int i = 0; i < 3; i++) {
                grid[i] = arr[i].toCharArray();
            }

            boolean isAWin = false;
            boolean isBWin = false;
            for (int i = 0; i < 3; i++) {
                if (grid[i][0] == 'A' && grid[i][1] == 'A' && grid[i][2] == 'A') {
                    isAWin = true;
                }

                if (grid[i][0] == 'B' && grid[i][1] == 'B' && grid[i][2] == 'B') {
                    isBWin = true;
                }
            }

            for (int j = 0; j < 3; j++) {
                if (grid[0][j] == 'A' && grid[1][j] == 'A' && grid[2][j] == 'A') {
                    isAWin = true;
                }

                if (grid[0][j] == 'B' && grid[1][j] == 'B' && grid[2][j] == 'B') {
                    isBWin = true;
                }
            }

            if (grid[0][0] == 'A' && grid[1][1] == 'A' && grid[2][2] == 'A') {
                isAWin = true;
            }

            if (grid[0][0] == 'B' && grid[1][1] == 'B' && grid[2][2] == 'B') {
                isBWin = true;
            }

            if (grid[0][2] == 'A' && grid[1][1] == 'A' && grid[2][0] == 'A') {
                isAWin = true;
            }

            if (grid[0][2] == 'B' && grid[1][1] == 'B' && grid[2][0] == 'B') {
                isBWin = true;
            }
            
            if (isAWin && isBWin) {
                System.out.println("invalid");
            } else if (isAWin) {
                System.out.println("Yes");
            } else if (isBWin) {
                System.out.println("No");
            } else {
                System.out.println("draw");
            }

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
