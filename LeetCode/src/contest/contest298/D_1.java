package contest.contest298;

import java.util.*;

public class D_1 {

    private long[][] memo;
    private int[][] p;

    private long rec(int h, int w) {
        if (h <= 0 || w <= 0) {
            return 0;
        }
        if (memo[h][w] != -1) {
            return memo[h][w];
        }

        // 水平切
        long ansMax = p[h][w];
        for (int i = 1; i < h; i++) {
            ansMax = Math.max(ansMax, rec(i, w) + rec(h - i, w));
        }

        // 垂直切
        for (int i = 1; i < w; i++) {
            ansMax = Math.max(ansMax, rec(h, i) + rec(h, w - i));
        }

        memo[h][w] = ansMax;
        return ansMax;
    }

    public long sellingWood(int m, int n, int[][] prices) {
        p = new int[m + 1][n + 1];
        for (int[] price: prices) {
            p[price[0]][price[1]] = price[2];
        }
        memo = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return rec(m, n);
    }

    public static void main(String[] args) {
//        System.out.println(new D().sellingWood(3, 5, new int[][]{
//                {1,4,2},{2,2,7},{2,1,3}
//        }));

//        9
//        7
//                [[4,3,2],[5,3,16],[4,4,18],[8,7,6]]

        System.out.println(new D_1().sellingWood(9, 7, new int[][]{
                {4,3,2},{5,3,16},{4,4,18},{8,7,6}
        }));
    }

}
