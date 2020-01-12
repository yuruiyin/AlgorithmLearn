package practice057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static int[] wArr;

    private static boolean backTrack(int[] leftWArr, int goodsIndex) {
        if (goodsIndex == wArr.length) {
            return true;
        }

        for (int i = 0; i < leftWArr.length; i++) {
            if (leftWArr[i] < wArr[goodsIndex]) {
                continue;
            }

            leftWArr[i] -= wArr[goodsIndex];
            boolean isFound = backTrack(leftWArr, goodsIndex + 1);
            if (isFound) {
                return true;
            }
            leftWArr[i] += wArr[goodsIndex];
        }

        return false;
    }

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int x = nextInt();
            int w = nextInt();
            wArr = new int[n];
            int minW = Integer.MAX_VALUE;
            int maxW = Integer.MIN_VALUE;
            long sumW = 0;
            for (int i = 0; i < n; i++) {
                wArr[i] = nextInt();
                minW = Math.min(minW, wArr[i]);
                maxW = Math.max(maxW, wArr[i]);
                sumW += wArr[i];
            }

            if (maxW > w) {
                System.out.println("No");
                continue;
            }

            if (x >= n) {
                System.out.println("Yes");
                continue;
            }

            if (sumW > (long) x * w) {
                System.out.println("No");
                continue;
            }

            int[] leftArr = new int[x];
            for (int i = 0; i < x; i++) {
                leftArr[i] = w;
            }

            Arrays.sort(wArr);
            boolean isOk = backTrack(leftArr, 0);

            if (isOk) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
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
