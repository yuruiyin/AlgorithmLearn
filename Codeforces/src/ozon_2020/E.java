package ozon_2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class E {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();

        if (m == 0) {
            for (int i = 10; i < n + 10; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        if (n - m < 2) {
            System.out.println(-1);
            return;
        }

        int[] ansArr = new int[n];
        ansArr[0] = 1;
        ansArr[1] = 2;
        int index = 2;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        while ((m--) > 0) {
            ansArr[index] = ansArr[index - 1] + ansArr[index - 2];
            set.add(ansArr[index]);
            index++;
        }

        if (index == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(ansArr[i] + " ");
            }
            System.out.println();
            return;
        }

        int leftCount = n - index;
        int from = (int) 1e9;
        ansArr[n - 1] = from;
        leftCount--;
        int i = n - 2;
        while ((leftCount--) > 0) {
            for (int j = 1; ; j++) {
                if (!set.contains(j)) {
                    ansArr[i] = ansArr[i + 1] - j;
                    i--;
                    break;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.print(ansArr[j] + " ");
        }
        System.out.println();
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
