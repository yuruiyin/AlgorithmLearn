package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static List<Long> getAllFactors(long num) {
        List<Long> list = new ArrayList<>();
        int end = (int) Math.sqrt(num);
        for (int i = 1; i <= end; i++) {
            if (num % i == 0) {
                list.add((long) i);
                list.add(num / i);
            }
        }

        return list;
    }

    private static void solve() throws IOException {
        long a = nextLong();
        long b = nextLong();
        List<Long> aFactors = getAllFactors(a);
        List<Long> bFactors = getAllFactors(b);

        Set<Long> set = new HashSet<>();
        for (Long factor : aFactors) {
            set.add(factor);
        }

        Set<Long> commonFactors = new TreeSet<>();
        for (Long factor: bFactors) {
            if (set.contains(factor)) {
                commonFactors.add(factor);
            }
        }
        
        for (Long factor : commonFactors) {
            System.out.print(factor + " ");
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
