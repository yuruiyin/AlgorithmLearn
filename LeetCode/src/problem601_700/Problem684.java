package problem601_700;

import dsu.LinkDSU;

/**
 * Problem684
 *
 * @author: yry
 * @date: 2020/3/23
 */
public class Problem684 {

    public int[] findRedundantConnection(int[][] edges) {
        //先求n
        int n = 0;
        for (int[] edge : edges) {
            n = Math.max(n, Math.max(edge[0], edge[1]));
        }

        LinkDSU dsu  = new LinkDSU(n);
        for (int[] edge : edges) {
            if (!dsu.union(edge[0] - 1, edge[1] - 1)) {
                return new int[]{edge[0], edge[1]};
            }
        }

        return null;
    }

}
