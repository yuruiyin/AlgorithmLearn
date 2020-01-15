package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class G {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    private static void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        // 区间排序
        int[][] intervals = new int[m][2];
        for (int i = 0; i < m; i++) {
            intervals[i][0] = nextInt();
            intervals[i][1] = nextInt();
        }
        
        if (m == 0) {
            System.out.println(n);
            return;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int max = intervals[0][0] - 1;
        int maxEnd = intervals[0][1];
        for (int i = 1; i < m; i++) {
            int[] interval = intervals[i];
            maxEnd = Math.max(maxEnd, interval[1]);
            if (interval[0] > intervals[i-1][1]) {
                max = Math.max(max, interval[0] - intervals[i][1] - 1);
            }
        }

        max = Math.max(max, n - maxEnd);
        
        System.out.println(max);
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
