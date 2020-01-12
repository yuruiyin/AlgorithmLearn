package practice057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int hpGamer = nextInt();
            int hpBoss = nextInt();
            int atkGamer = nextInt();
            int atkBoss = nextInt();
            int m = nextInt();

            if (atkGamer >= hpBoss) {
                System.out.println("Yes");
                continue;
            }

            if (m >= atkGamer) {
                System.out.println("No");
                continue;
            }

            long roundCount = hpGamer / atkBoss + (hpGamer % atkBoss == 0 ? 0 : 1);
            if (hpBoss <= (atkGamer - m) * (roundCount - 1) + atkGamer) {
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
