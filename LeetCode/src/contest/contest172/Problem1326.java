package contest.contest172;

public class Problem1326 {

    class Interval {
        int s;
        int e;

        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int minTaps(int n, int[] ranges) {
        Interval[] intervals = new Interval[n + 1];
        for (int i = 0; i < n + 1; i++) {
            intervals[i] = new Interval(i - ranges[i], i + ranges[i]);
        }

        int from = 0;
        boolean[] visited = new boolean[n + 1];
        int ans = 0;
        while (from < n) {
            int maxEnd = 0;
            int targetIndex = -1;
            for (int i = 0; i <= n; i++) {
                if (!visited[i] && intervals[i].s <= from && intervals[i].e > maxEnd) {
                    maxEnd = intervals[i].e;
                    targetIndex = i;
                }
            }

            if (targetIndex == -1) {
                return -1;
            }

            from = maxEnd;
            visited[targetIndex] = true;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem1326().minTaps(3, new int[]{0, 0, 0, 0}));
    }

}
