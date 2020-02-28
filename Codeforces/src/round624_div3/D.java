package round624_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static List<Integer> getAllFactors(int num) {
        List<Integer> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }

        Collections.sort(list);
        return list;
    }

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            if (b % a == 0 && c % b == 0) {
                System.out.println(0);
                System.out.println(a + " " + b + " " + c);
                continue;
            }

            if (b == c) {
                List<Integer> factors = getAllFactors(b);
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < factors.size(); i++) {
                    if (a < factors.get(i)) {
                        min = Math.min(factors.get(i) - a, a - factors.get(i-1));
                        break;
                    }
                }

                int value = b / a;
                min = Math.min(min, (b - a * value) * 2);
                min = Math.min(min, (a * (value + 1) - b) * 2);
                
                System.out.println(min);
                continue;
            }

            if (a == b) {
                List<Integer> factors = getAllFactors(c);
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < factors.size(); i++) {
                    if (a < factors.get(i)) {
                        min = Math.min(factors.get(i) - a, a - factors.get(i-1));
                        break;
                    }
                }

                min *= 2;
                int value = c / a;
                min = Math.min(min, c - a * value);
                min = Math.min(min, a * (value + 1) - b);

                System.out.println(min);
                continue;
            }

            // a != b != c

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
