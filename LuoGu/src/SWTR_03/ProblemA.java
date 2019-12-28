package SWTR_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ProblemA {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static boolean isFound(String pwd, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if (str.indexOf(pwd.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        int k = nextInt();
        String pwd = next();
        String[] arr = new String[n];
        long totalCount = 1;
        for (int i = 0; i < n ; i++) {
            int count = nextInt();
            arr[i] = next();
            totalCount *= count;
        }

        Set<String> visited = new HashSet<>();
        for (int i = 0; i < k; i++) {
            visited.add(next());
        }

        if (!isFound(pwd, arr)) {
            System.out.println(-1);
            return;
        }

        int tryCount = 0;
        for (String str: visited) {
            if (isFound(str, arr)) {
                tryCount++;
            }
        }

        System.out.println(totalCount - tryCount);

//        PrintWriter out = new PrintWriter(System.out);
//        out.println();
//        out.close();
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
