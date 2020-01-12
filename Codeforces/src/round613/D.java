package round613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }

        if (n == 1) {
            System.out.println(0);
            return;
        }

        int[][] grid = new int[n][32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                grid[i][32 - j - 1] = arr[i] & 1;
                arr[i] >>>= 1;
            }
        }

        int ans = 0;
        List<Integer> zeroIndexList = new ArrayList<>();
        List<Integer> oneIndexList = new ArrayList<>();
        boolean canCmpZero = true;
        boolean canCmpOne = true;
        for (int j = 0; j < 32; j++) {
            boolean isSame = true;
            int lastValue = grid[0][j];
            for (int i = 1; i < n; i++) {
                if (grid[i][j] != lastValue) {
                    isSame = false;
                    break;
                }
            }

            ans <<= 1;
            if (isSame) {
                continue;
            }

            //判断与前面是否
            if (ans != 0) {
                boolean isSame1 = false;
                if (canCmpZero) {
                    int firstZeroIndexValue = grid[zeroIndexList.get(0)][j];
                    isSame1 = true;
                    for (int i = 1; i < zeroIndexList.size(); i++) {
                        int zeroIndex = zeroIndexList.get(i);
                        if (grid[zeroIndex][j] != firstZeroIndexValue) {
                            isSame1 = false;
                            break;
                        }
                    }
                }

                boolean isSame2 = false;
                if (canCmpOne) {
                    int firstOneIndexValue = grid[oneIndexList.get(0)][j];
                    isSame2 = true;
                    for (int i = 1; i < oneIndexList.size(); i++) {
                        int oneIndex = oneIndexList.get(i);
                        if (grid[oneIndex][j] != firstOneIndexValue) {
                            isSame2 = false;
                            break;
                        }
                    }
                }


                if (isSame1 || isSame2) {
                    if (!isSame1) {
                        canCmpZero = false;
                        canCmpOne = true;
                    }

                    if (!isSame2) {
                        canCmpOne = false;
                        canCmpZero = true;
                    }
                    continue;
                }
            }

            ans++;

            if (ans == 1) {
                zeroIndexList.clear();
                oneIndexList.clear();
                for (int i = 0; i < n; i++) {
                    if (grid[i][j] == 0) {
                        zeroIndexList.add(i);
                    } else {
                        oneIndexList.add(i);
                    }
                }
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
