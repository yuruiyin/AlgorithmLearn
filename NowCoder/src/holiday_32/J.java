package holiday_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J {

    private static final int MOD = 97654321;

    private static BufferedReader br;
    private static StringTokenizer tokenizer;
    private static List<Character>[] nextListArr;
    private static Integer[][][] memo;

    private static int dp(char curChar, int u, int l) {
        if (u == 0 && l == 0) {
            return 1;
        }

        if (nextListArr[curChar] == null) {
            return 0;
        }

        if (u < 0 || l < 0) {
            return 0;
        }

        if (memo[curChar][u][l] != null) {
            return memo[curChar][u][l];
        }

        long ans = 0;
        for (Character nextChar : nextListArr[curChar]) {
            if (Character.isLowerCase(nextChar)) {
                ans = (ans + dp(nextChar, u, l - 1)) % MOD;
            } else {
                ans = (ans + dp(nextChar, u - 1, l)) % MOD;
            }
        }

        memo[curChar][u][l] = (int)ans;
        return memo[curChar][u][l];
    }

    private static void solve() throws IOException {
        int u = nextInt();
        int l = nextInt();
        int p = nextInt();

        nextListArr = new ArrayList[128];
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < p; i++) {
            String pair = next();
            char firstChar = pair.charAt(0);
            char secondChar = pair.charAt(1);

            charSet.add(firstChar);
            charSet.add(secondChar);

            if (nextListArr[firstChar] == null) {
                nextListArr[firstChar] = new ArrayList<>();
            }

            nextListArr[firstChar].add(secondChar);
        }

        long ans = 0;
        memo = new Integer[128][u + 1][l + 1];
        for (Character c : charSet) {
            if (Character.isLowerCase(c)) {
                ans = (ans + dp(c, u, l - 1)) % MOD;
            } else {
                ans = (ans + dp(c, u - 1, l)) % MOD;
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
