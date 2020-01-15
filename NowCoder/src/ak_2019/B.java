package ak_2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    static class Interval {
        int l;
        int r;
        int cost;
        Interval(int l, int r, int cost) {
            this.l = l;
            this.r = r;
            this.cost = cost;
        }
    }

    private static void solve() throws IOException {
        // 区间合并，然后二分
        int n = nextInt();
        int k = nextInt();
        int m = nextInt();
        int[] bArr = new int[n];
        for (int i = 0; i < n; i++) {
            bArr[i] = nextInt();
        }

        Interval[] intervals = new Interval[m];
        for (int i = 0; i < m; i++) {
            int l = nextInt();
            int r = nextInt();
            int cost = nextInt();
            intervals[i] = new Interval(l, r, cost);
        }

        // 区间排序
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.l == o2.l) {
                    return o1.cost - o2.cost;
                } else {
                    return o1.l - o2.l;
                }
            }
        });

        // 删除区间相同的费用较大区间
        List<Interval> intervalList = new ArrayList<>();
        intervalList.add(intervals[0]);
        for (int i = 1; i < m-1; i++) {
            if (intervals[i].l == intervals[i-1].l && intervals[i].r == intervals[i-1].r) {
                continue;
            }

            intervalList.add(intervals[i]);
        }

        List<Interval> newIntervalList = new ArrayList<>();
        newIntervalList.add(intervalList.get(0));
        for (int i = 1; i < intervalList.size(); i++) {
            Interval nearInterval = newIntervalList.get(0);
            if (intervalList.get(i).l == nearInterval.l) {

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
