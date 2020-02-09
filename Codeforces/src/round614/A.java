package round614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class A {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int t = nextInt();
        while ((t--) > 0) {
            int n = nextInt();
            int s = nextInt();
            int k = nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = nextInt();
            }

            Arrays.sort(arr);
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < k; i++) {
                set.add(arr[i]);
            }

            if (!set.contains(s)) {
                System.out.println(0);
                continue;
            }

            int index = -1;
            for (int i = 0; i < k; i++) {
                if (s == arr[i]) {
                    index = i;
                    break;
                }
            }

            int rightLen = Integer.MAX_VALUE;
            for (int i = index + 1; i < k; i++) {
                if (arr[i] - arr[i-1] != 1) {
                    rightLen = arr[i-1] + 1 - arr[index];
                    break;
                }
            }

            if (rightLen == Integer.MAX_VALUE && arr[k-1] < n) {
                rightLen = arr[k-1] + 1 - arr[index];
            }

            int leftLen = Integer.MAX_VALUE;
            for (int i = index - 1; i >= 0; i--) {
                if (arr[i+1] - arr[i] != 1) {
                    leftLen = arr[index] - (arr[i+1] - 1);
                    break;
                }
            }

            if (leftLen == Integer.MAX_VALUE && arr[0] > 1) {
                leftLen = arr[index] - (arr[0] - 1);
            }
            
            System.out.println(Math.min(leftLen, rightLen));

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
