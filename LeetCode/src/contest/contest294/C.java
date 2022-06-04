package contest.contest294;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    public int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length;
        if (len <= 2) {
            return len - 1;
        }

        Arrays.sort(stockPrices, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int[] first = stockPrices[0];
        int[] pre = stockPrices[1];
        int ans = 1;

        for (int i = 2; i < len; i++) {
            long x1 = first[0];
            long y1 = first[1];
            long x2 = pre[0];
            long y2 = pre[1];
            int[] cur = stockPrices[i];
            long x3 = cur[0];
            long y3 = cur[1];
            if ((y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1)) {
                pre = cur;
                continue;
            }
            ans++;
            first = pre;
            pre = cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        // [[1,1],[2,2],[3,3],[4,5],[5,7],[6,6],[7,5],[8,4],[9,4],[10,4]]
        System.out.println(new C().minimumLines(new int[][]{
                {1,1},{2,2},{3,3},{4,5},{5,7},{6,6},{7,5},{8,4},{9,4},{10,4}
        }));
    }

}
