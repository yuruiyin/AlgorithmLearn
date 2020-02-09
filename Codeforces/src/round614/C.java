package round614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class C {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int q = nextInt();
        int[][] arr = new int[q][2];
        for (int i = 0; i < q; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
        }

        Set<Integer> firstRowColSet = new HashSet<>();
        Set<Integer> secondRowColSet = new HashSet<>();
        Set<Long> neighborSet = new HashSet<>();

        for (int i = 0; i < q; i++) {
            int[] tmpArr = arr[i];
            int r = tmpArr[0];
            int c = tmpArr[1];
            if (r == 1) {
                if (firstRowColSet.contains(c)) {
                    firstRowColSet.remove(c);
                    neighborSet.remove(c * 100000L + (c-1));
                    neighborSet.remove(c * 100000L + (c+1));
                    neighborSet.remove(c * 100000L + c);
                } else {
                    firstRowColSet.add(c);
                    if (secondRowColSet.contains(c - 1)) {
                        neighborSet.add(c * 100000L + (c - 1));
                    }

                    if (secondRowColSet.contains(c + 1)) {
                        neighborSet.add(c * 100000L + (c + 1));
                    }

                    if (secondRowColSet.contains(c)) {
                        neighborSet.add(c * 100000L + c);
                    }
                }
            } else {
                if (secondRowColSet.contains(c)) {
                    secondRowColSet.remove(c);
                    neighborSet.remove((c-1) * 100000L + c);
                    neighborSet.remove((c+1) * 100000L + c);
                    neighborSet.remove(c * 100000L + c);
                } else {
                    secondRowColSet.add(c);
                    if (firstRowColSet.contains(c - 1)) {
                        neighborSet.add((c-1) * 100000L + c);
                    }

                    if (firstRowColSet.contains(c + 1)) {
                        neighborSet.add((c+1) * 100000L + c);
                    }

                    if (firstRowColSet.contains(c)) {
                        neighborSet.add(c * 100000L + c);
                    }
                }
            }

            if (neighborSet.isEmpty()) {
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
