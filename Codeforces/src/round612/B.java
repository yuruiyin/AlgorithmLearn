package round612;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static char getThirdChar(char c1, char c2) {
        if (c1 == 'S' && c2 == 'T' || c1 == 'T' && c2 == 'S') {
            return 'E';
        }

        if (c1 == 'S' && c2 == 'E' || c1 == 'E' && c2 == 'S') {
            return 'T';
        }

        if (c1 == 'T' && c2 == 'E' || c1 == 'E' && c2 == 'T') {
            return 'S';
        }

        return 'S';

    }

    private static void solve() throws IOException {
        int n = nextInt();
        int k = nextInt();
        String[] arr = new String[n];
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = next();
            indexMap.put(arr[i], i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str1 = arr[i];
            for (int j = i + 1; j < n; j++) {
                String str2 = arr[j];
                StringBuilder sb = new StringBuilder();
                for (int l = 0; l < k; l++) {
                    char c1 = str1.charAt(l);
                    char c2 = str2.charAt(l);
                    if (c1 == c2) {
                        sb.append(c1);
                    } else {
                        sb.append(getThirdChar(c1, c2));
                    }

                    String str3 = sb.toString();
                    if (indexMap.containsKey(str3) && indexMap.get(str3) > j) {
                        ans++;
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
