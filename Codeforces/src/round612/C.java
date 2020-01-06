package round612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static int[][][][] memo;
    private static int len;
    private static int[] arr;

    private static boolean isOdd(int num) {
        return num % 2 == 1;
    }

    private static int backTrack(int from, int oddCount, int evenCount, boolean isLastOdd) {
        if (from == len) {
            return 0;
        }

        if (from == len - 1) {
            if (from == 0) {
                return 0;
            }

            boolean isCurNumOdd = arr[from] != 0 ? isOdd(arr[from]) : oddCount == 1;
            if (isCurNumOdd && !isLastOdd || !isCurNumOdd && isLastOdd) {
                return 1;
            }
            return 0;
        }

        if (memo[from][oddCount][evenCount][isLastOdd ? 1 : 0] != -1) {
            return memo[from][oddCount][evenCount][isLastOdd ? 1 : 0];
        }

        if (oddCount == 0 && evenCount == 0) {
            int count = 0;
            for (int i = from; i < len - 1; i++) {
                if (isOdd(arr[i]) && !isOdd(arr[i+1]) || !isOdd(arr[i]) && isOdd(arr[i+1])) {
                    count++;
                }
            }

            if (from == 0) {
                return count;
            }

            boolean isCurNumOdd = isOdd(arr[from]);
            if (isCurNumOdd && !isLastOdd || !isCurNumOdd && isLastOdd) {
                count++;
            }

            memo[from][oddCount][evenCount][isLastOdd ? 1 : 0] = count;
            return count;
        }

        if (arr[from] != 0) {
            boolean isCurNumOdd = isOdd(arr[from]);
            int count = backTrack(from + 1, oddCount, evenCount, isCurNumOdd);
            if (from == 0) {
                return count;
            }

            if (isCurNumOdd && !isLastOdd || !isCurNumOdd && isLastOdd) {
                count++;
            }

            memo[from][oddCount][evenCount][isLastOdd ? 1 : 0] = count;
            return count;
        }

        // 当前等于0，需要填补
        int curOddMinCount = Integer.MAX_VALUE;
        if (oddCount > 0) {
            curOddMinCount = backTrack(from + 1, oddCount - 1, evenCount, true);
            if (from > 0 && !isLastOdd) {
                curOddMinCount++;
            }
        }

        int curEvenMinCount = Integer.MAX_VALUE;
        if (evenCount > 0) {
            curEvenMinCount = backTrack(from + 1, oddCount, evenCount - 1, false);
            if (from > 0 && isLastOdd) {
                curEvenMinCount++;
            }
        }

        if (curOddMinCount < curEvenMinCount) {
            memo[from][oddCount][evenCount][isLastOdd ? 1 : 0] = curOddMinCount;
            return curOddMinCount;
        }

        memo[from][oddCount][evenCount][isLastOdd ? 1 : 0] = curEvenMinCount;
        return curEvenMinCount;
    }

    private static void solve() throws IOException {
        int n = nextInt();
        arr = new int[n];
        for (int i =0; i < n; i++) {
            arr[i] = nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                set.add(arr[i]);
            }
        }

        int oddCount = 0;
        int evenCount = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if ((i & 1) == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }

        len = n;
        memo = new int[n+1][n+1][n+1][2];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    for (int l = 0; l < 2; l++) {
                        memo[i][j][k][l] = -1;
                    }
                }
            }
        }
        int minCount = backTrack(0, oddCount, evenCount, true);
        System.out.println(minCount);
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
